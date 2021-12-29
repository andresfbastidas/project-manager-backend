package co.edu.usbcali.projectmanager.business.implement;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.projectmanager.business.interfaces.IProjectService;
import co.edu.usbcali.projectmanager.business.utils.ServiceUtils;
import co.edu.usbcali.projectmanager.model.constant.KeyConstants;
import co.edu.usbcali.projectmanager.model.dto.ProjectUserDirectorNameDTO;
import co.edu.usbcali.projectmanager.model.dto.UsersByProjectDTO;
import co.edu.usbcali.projectmanager.model.entities.Delivery;
import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.entities.ProjectDelivery;
import co.edu.usbcali.projectmanager.model.entities.ProjectRequest;
import co.edu.usbcali.projectmanager.model.entities.ProjectUser;
import co.edu.usbcali.projectmanager.model.entities.State;
import co.edu.usbcali.projectmanager.model.entities.StateProjectRequest;
import co.edu.usbcali.projectmanager.model.entities.Userapp;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.ApprovalDeclineRequest;
import co.edu.usbcali.projectmanager.model.request.AssociatedUserProjectRequest;
import co.edu.usbcali.projectmanager.model.request.CreateProjectRequest;
import co.edu.usbcali.projectmanager.model.response.ListUsersByProjectResponse;
import co.edu.usbcali.projectmanager.model.response.ProjectListByStateResponse;
import co.edu.usbcali.projectmanager.model.response.ProjectListResponse;
import co.edu.usbcali.projectmanager.model.response.UserNameResponse;
import co.edu.usbcali.projectmanager.repository.ProjectDeliveryRepository;
import co.edu.usbcali.projectmanager.repository.ProjectRepository;
import co.edu.usbcali.projectmanager.repository.ProjectRequestRepository;
import co.edu.usbcali.projectmanager.repository.ProjectUserDirectorNameRepository;
import co.edu.usbcali.projectmanager.repository.ProjectUserRepository;
import co.edu.usbcali.projectmanager.repository.UsersByProjectsRepository;

@Service
public class ProjectServiceImpl extends ServiceUtils implements IProjectService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	private static final String CLASS_NAME = "ProjectServiceImpl";

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ProjectDeliveryRepository projectDeliveryRepository;

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private ProjectUserRepository projectUserRepository;

	@Autowired
	private ProjectUserDirectorNameRepository projectUserDirectorNameRepository;

	@Autowired
	private UsersByProjectsRepository usersByProjectsRepository;

	@Autowired
	private ProjectRequestRepository projectRequestRepository;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void createProject(CreateProjectRequest createProjectRequest) throws ProjectManagementException {
		try {
			Project project = buildProject(createProjectRequest.getProject().getDateFrom(),
					createProjectRequest.getProject().getDateUntil(),
					createProjectRequest.getProject().getProjectTitle(),
					createProjectRequest.getProject().getGeneralObjetive(),
					createProjectRequest.getProject().getProjectSummary(),
					createProjectRequest.getProject().getProjectMethology(),
					createProjectRequest.getProject().getSpecificObjetive(),
					createProjectRequest.getProject().getJustification(),
					createProjectRequest.getProject().getProjectResearchTypologyId(), createProjectRequest.getState(),
					createProjectRequest.getUserapp().getUserName(), createProjectRequest.getProject().getCreateBy());

			UserNameResponse userNameResponse = new UserNameResponse();
			userNameResponse = userDetailsServiceImpl.findByUserName(createProjectRequest.getUserapp().getUserName());
			projectRepository.saveAndFlush(project);
			this.saveProjectDelivery(createProjectRequest.getDeliveries(), project);
			if (createProjectRequest.getState().getStateId().equals(KeyConstants.SOLINI_STATE)) {
				ProjectRequest projectRequest = new ProjectRequest();
				projectRequest.setProject(project);
				projectRequest.setUserapp(userNameResponse.getUserapp());
				StateProjectRequest stateProjectRequest = new StateProjectRequest();
				stateProjectRequest.setStateProjectRequestId(KeyConstants.PENDING_STATE);
				projectRequest.setStateProjectRequest(stateProjectRequest);
				projectRequestRepository.save(projectRequest);
			} else {
				AssociatedUserProjectRequest associatedUserProjectRequest = new AssociatedUserProjectRequest();
				associatedUserProjectRequest.setProject(project);
				associatedUserProjectRequest.setUserapp(userNameResponse.getUserapp());
				this.associateUser(associatedUserProjectRequest);
			}

		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public ProjectDelivery saveProjectDelivery(List<Delivery> listDeliveries, Project project)
			throws ProjectManagementException {
		ProjectDelivery projectDelivery = null;
		try {
			if (project != null || !listDeliveries.isEmpty()) {
				for (Delivery delivery : listDeliveries) {
					projectDelivery = new ProjectDelivery();
					projectDelivery.setDelivery(delivery);
					projectDelivery.setProject(project);
					projectDeliveryRepository.saveAndFlush(projectDelivery);
				}
			} else {
				buildCustomException(KeyConstants.PROJECT_NOT_SAVE, KeyConstants.ERROR_CODE_LIST_USERS_EMPTY);
			}
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}

		return projectDelivery;
	}

	@Override
	@Transactional(readOnly = true)
	public Project findByProjectId(Long projectId) throws ProjectManagementException {
		Project project = null;
		try {
			project = projectRepository.findByProjectId(projectId);

			if (project == null) {
				buildCustomException(KeyConstants.PROJECT_NOT_EXISTS, KeyConstants.ERROR_CODE_LIST_USERS_EMPTY);
			}

		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
		return project;

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void associateUser(AssociatedUserProjectRequest associatedUserProject) throws ProjectManagementException {
		UserNameResponse userNameResponse = null;
		try {
			userNameResponse = userDetailsServiceImpl.findByUserName(associatedUserProject.getUserapp().getUserName());

			Project project = this.findByProjectId(associatedUserProject.getProject().getProjectId());
			this.saveProjectUser(project, userNameResponse.getUserapp());

		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void saveProjectUser(Project project, Userapp userapp) throws ProjectManagementException {
		ProjectUser projectUser = null;
		try {
			projectUser = projectUserRepository.findUserExists(userapp.getUserName(), project.getProjectId());
			if (projectUser != null) {
				buildCustomException(KeyConstants.ERROR_ASSOCIATED_PROJECT_USER_EXISTS,
						KeyConstants.ERROR_CODE_ASSOCIATED_PROJECT_USER);
			}
			/*
			 * UserNameResponse userNameResponse = new UserNameResponse(); userNameResponse
			 * = userDetailsServiceImpl.findByUserName(userapp.getUserName());
			 * 
			 * if (userNameResponse.getUserapp().getProfile().getProfileId() ==
			 * KeyConstants.ROL_DIRECTORID) { buildCustomException(KeyConstants.
			 * ERROR_ASSOCIATED_PROJECT_USER_PROFILE_DIRECTOR,
			 * KeyConstants.ERROR_CODE_ASSOCIATED_PROJECT_USER); }
			 */
			projectUser = new ProjectUser();
			projectUser.setProject(project);
			projectUser.setUserapp(userapp);
			projectUserRepository.saveAndFlush(projectUser);

		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectListByStateResponse<Project> findAllProjectByState() throws ProjectManagementException {
		ProjectListByStateResponse<Project> projectListResponse = null;
		List<Project> projects = null;
		try {
			projectListResponse = new ProjectListByStateResponse<Project>();
			projects = projectRepository.findAllByProjectState(KeyConstants.AVALAIBLE_STATE);
			if (projects.isEmpty() || projects == null) {
				buildCustomException(KeyConstants.PROJECTS_NOT_FOUND,
						KeyConstants.ERROR_CODE_GENERIC_LIST_EMPTY);
			}
			projectListResponse.setProjectList(projects);
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
		return projectListResponse;
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectListResponse<ProjectUserDirectorNameDTO> findAllProjectsByUserName(String userName)
			throws ProjectManagementException {
		ProjectListResponse<ProjectUserDirectorNameDTO> projectListResponse = null;
		List<ProjectUserDirectorNameDTO> projectList = null;
		try {
			projectListResponse = new ProjectListResponse<ProjectUserDirectorNameDTO>();
			projectList = projectUserDirectorNameRepository.findAllProjectsByUserName(KeyConstants.ROL_DIRECTORID,
					userName);
			if (projectList.isEmpty() || projectList == null) {
				buildCustomException(KeyConstants.PROJECT_LIST_EMPTY, KeyConstants.ERROR_CODE_PROJECT_LIST_EMPTY);
			}

			projectListResponse.setProjectList(projectList);
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}

		return projectListResponse;
	}

	private Project buildProject(Date dateFrom, Date dateUntil, String projectTitle, String generalObjetive,
			String projectSummary, String projectMethology, String specificObjetive, String justification,
			Long projectResearchId, State state, String projectDirector, String createBy) {
		Project project = new Project();
		project.setDateFrom(dateFrom);
		project.setDateUntil(dateUntil);
		project.setProjectTitle(projectTitle);
		project.setGeneralObjetive(generalObjetive);
		project.setProjectSummary(projectSummary);
		project.setProjectMethology(projectMethology);
		project.setSpecificObjetive(specificObjetive);
		project.setJustification(justification);
		project.setProjectResearchTypologyId(projectResearchId);
		project.setState(state);
		project.setProjectDirector(projectDirector);
		project.setCreateBy(createBy);
		return project;
	}

	@Override
	@Transactional(readOnly = true)
	public ListUsersByProjectResponse<UsersByProjectDTO> listUsersByProject(Long projectId)
			throws ProjectManagementException {
		List<UsersByProjectDTO> listUsersByProjectDTOs = null;
		ListUsersByProjectResponse<UsersByProjectDTO> listUsersByProjectResponse = null;
		try {
			listUsersByProjectDTOs = usersByProjectsRepository.listAllUsersByProject(projectId);
			if (listUsersByProjectDTOs.isEmpty() || listUsersByProjectDTOs == null) {
				buildCustomException(KeyConstants.ERROR_USERS_BY_PROJECT, KeyConstants.ERROR_CODE_USERS_BY_PROJECT);
			}
			listUsersByProjectResponse = new ListUsersByProjectResponse<UsersByProjectDTO>();
			listUsersByProjectResponse.setListUsers(listUsersByProjectDTOs);
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
		return listUsersByProjectResponse;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectRequest> findProjectRequestbByState() throws ProjectManagementException {
		List<ProjectRequest> listProjectRequests = null;
		try {
			listProjectRequests = projectRequestRepository.findProjectRequestByState(KeyConstants.PENDING_STATE);
			if (listProjectRequests.isEmpty() || listProjectRequests == null) {
				buildCustomException(KeyConstants.ERROR_LIST_PROJECT_REQUEST_EMPTY,
						KeyConstants.ERROR_CODE_LIST_PROJECT_REQUEST_EMPTY);
			}
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
		return listProjectRequests;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void apprrovalProject(ApprovalDeclineRequest approvalDeclineRequest) throws ProjectManagementException {
		try {

			for (ProjectRequest projectRequest : approvalDeclineRequest.getListProjectRequests()) {
				if (projectRequest.getStateProjectRequest().getStateProjectRequestId()
						.equals(KeyConstants.PENDING_STATE)) {
					projectRequestRepository.updateProjectRequest(KeyConstants.APPROVAL_STATE,
							projectRequest.getDetails(), projectRequest.getProjectRequestId());
					AssociatedUserProjectRequest associatedUserProjectRequest = new AssociatedUserProjectRequest();
					associatedUserProjectRequest.setProject(projectRequest.getProject());
					associatedUserProjectRequest.setUserapp(projectRequest.getUserapp());
					this.associateUser(associatedUserProjectRequest);
				}

			}
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
	}

}
