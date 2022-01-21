package co.edu.usbcali.projectmanager.business.implement;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.projectmanager.business.interfaces.IProjectService;
import co.edu.usbcali.projectmanager.business.utils.ServiceUtils;
import co.edu.usbcali.projectmanager.model.constant.KeyConstants;
import co.edu.usbcali.projectmanager.model.dto.ProjectRequestDTO;
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
import co.edu.usbcali.projectmanager.model.request.ApprovalRequest;
import co.edu.usbcali.projectmanager.model.request.AssociatedUserProjectRequest;
import co.edu.usbcali.projectmanager.model.request.CreateProjectRequest;
import co.edu.usbcali.projectmanager.model.request.DeclineRequest;
import co.edu.usbcali.projectmanager.model.response.ListProjectRequestsResponse;
import co.edu.usbcali.projectmanager.model.response.ListUsersByProjectResponse;
import co.edu.usbcali.projectmanager.model.response.ProjectListByStateResponse;
import co.edu.usbcali.projectmanager.model.response.ProjectListResponse;
import co.edu.usbcali.projectmanager.repository.ProjectDeliveryRepository;
import co.edu.usbcali.projectmanager.repository.ProjectRepository;
import co.edu.usbcali.projectmanager.repository.ProjectRequestDTORepository;
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

	@Autowired
	private ProjectRequestDTORepository projectRequestDTORepository;

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
					createProjectRequest.getProject().getProjectDirector(),
					createProjectRequest.getUserapp().getUserName());

			Userapp userapp = new Userapp();
			userapp = userDetailsServiceImpl.findByUserName(createProjectRequest.getUserapp().getUserName());
			projectRepository.saveAndFlush(project);
			this.saveProjectDelivery(createProjectRequest.getDeliveries(), project);
			if (createProjectRequest.getState().getStateId().equals(KeyConstants.SOLINI_STATE)) {
				ProjectRequest projectRequest = new ProjectRequest();
				projectRequest.setProject(project);
				projectRequest.setUserapp(userapp);
				StateProjectRequest stateProjectRequest = new StateProjectRequest();
				stateProjectRequest.setStateProjectRequestId(KeyConstants.PENDING_STATE);
				projectRequest.setStateProjectRequest(stateProjectRequest);
				projectRequestRepository.save(projectRequest);
			} else {
				AssociatedUserProjectRequest associatedUserProjectRequest = new AssociatedUserProjectRequest();
				associatedUserProjectRequest.setProjectId(project.getProjectId());
				associatedUserProjectRequest.setUserName(userapp.getUserName());
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
		Userapp userapp = null;
		try {
			userapp = userDetailsServiceImpl.findByUserName(associatedUserProject.getUserName());

			Project project = this.findByProjectId(associatedUserProject.getProjectId());
			if (project.getState().getStateId() == KeyConstants.AVALAIBLE_STATE
					|| project.getState().getStateId() == KeyConstants.PROGRESS_STATE) {
				this.saveProjectUser(project, userapp);
			} else {
				buildCustomException(KeyConstants.ERROR_NOT_ASSOCIATED_USER_PROJECT,
						KeyConstants.ERROR_CODE_NOT_ASSOCIATED_USER_PROJECT);
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
	public ProjectListByStateResponse<Project> findAllProjectByState(Pageable page, Long stateId)
			throws ProjectManagementException {
		ProjectListByStateResponse<Project> projectListResponse = null;
		Page<Project> projects = null;
		try {
			projectListResponse = new ProjectListByStateResponse<Project>();
			projects = projectRepository.findAllByProjectState(page, stateId);

			if (projects.getContent().isEmpty() || projects.getContent() == null) {
				buildCustomException(KeyConstants.PROJECTS_NOT_FOUND, KeyConstants.ERROR_CODE_GENERIC_LIST_EMPTY);
			}

			projectListResponse.setProjectList(projects.getContent());
			projectListResponse.setCurrentPage(projects.getNumber());
			projectListResponse.setTotalElements(projects.getTotalElements());
			projectListResponse.setTotalPages(projects.getTotalPages());
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
	public ProjectListResponse<ProjectUserDirectorNameDTO> findAllProjectsByUserName(Pageable page, String userName)
			throws ProjectManagementException {
		ProjectListResponse<ProjectUserDirectorNameDTO> projectListResponse = null;
		Page<ProjectUserDirectorNameDTO> projectList = null;
		try {
			projectListResponse = new ProjectListResponse<ProjectUserDirectorNameDTO>();
			projectList = projectUserDirectorNameRepository.findAllProjectsByUserName(page, KeyConstants.ROL_DIRECTORID,
					userName);
			if (projectList.getContent().isEmpty() || projectList.getContent() == null) {
				buildCustomException(KeyConstants.PROJECT_LIST_EMPTY, KeyConstants.ERROR_CODE_PROJECT_LIST_EMPTY);
			}

			projectListResponse.setProjectList(projectList.getContent());
			projectListResponse.setCurrentPage(projectList.getNumber());
			projectListResponse.setTotalElements(projectList.getTotalElements());
			projectListResponse.setTotalPages(projectList.getTotalPages());
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
	public ListUsersByProjectResponse<UsersByProjectDTO> listUsersByProject(Pageable page, Long projectId)
			throws ProjectManagementException {
		Page<UsersByProjectDTO> listUsersByProjectDTOs = null;
		ListUsersByProjectResponse<UsersByProjectDTO> listUsersByProjectResponse = null;
		try {
			listUsersByProjectDTOs = usersByProjectsRepository.listAllUsersByProject(page, projectId);
			if (listUsersByProjectDTOs.getContent().isEmpty() || listUsersByProjectDTOs.getContent() == null) {
				buildCustomException(KeyConstants.ERROR_USERS_BY_PROJECT, KeyConstants.ERROR_CODE_USERS_BY_PROJECT);
			}
			listUsersByProjectResponse = new ListUsersByProjectResponse<UsersByProjectDTO>();
			listUsersByProjectResponse.setListUsers(listUsersByProjectDTOs.getContent());
			listUsersByProjectResponse.setCurrentPage(listUsersByProjectDTOs.getNumber());
			listUsersByProjectResponse.setTotalElements(listUsersByProjectDTOs.getTotalElements());
			listUsersByProjectResponse.setTotalPages(listUsersByProjectDTOs.getTotalPages());
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
	public ListProjectRequestsResponse findProjectRequestByState(Pageable page, Long stateProjectRequestFirst,
			Long stateProjectRequestSecond, Long stateProjectRequestThird, String userName)
			throws ProjectManagementException {
		Page<ProjectRequestDTO> listProjectRequests = null;
		ListProjectRequestsResponse listProjectRequestsResponse = null;
		try {
			listProjectRequests = projectRequestDTORepository.findProjectRequestByStateForDirector(page,
					stateProjectRequestFirst, stateProjectRequestSecond, stateProjectRequestThird, userName);
			if (listProjectRequests.getContent().isEmpty() || listProjectRequests.getContent() == null) {
				buildCustomException(KeyConstants.ERROR_LIST_PROJECT_REQUEST_EMPTY,
						KeyConstants.ERROR_CODE_LIST_PROJECT_REQUEST_EMPTY);
			}

			listProjectRequestsResponse = new ListProjectRequestsResponse();
			listProjectRequestsResponse.setListProjectRequests(listProjectRequests.getContent());
			listProjectRequestsResponse.setCurrentPage(listProjectRequests.getNumber());
			listProjectRequestsResponse.setTotalElements(listProjectRequests.getTotalElements());
			listProjectRequestsResponse.setTotalPages(listProjectRequests.getTotalPages());
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
		return listProjectRequestsResponse;
	}

	@Override
	@Transactional(readOnly = true)
	public ListProjectRequestsResponse findProjectRequestByStateUser(Pageable page, Long stateProjectRequestFirst,
			Long stateProjectRequestSecond, Long stateProjectRequestThird, String userName)
			throws ProjectManagementException {
		Page<ProjectRequestDTO> listProjectRequests = null;
		ListProjectRequestsResponse listProjectRequestsResponse = null;
		try {
			listProjectRequests = projectRequestDTORepository.findProjectRequestByStateForUser(page,
					stateProjectRequestFirst, stateProjectRequestSecond, stateProjectRequestThird, userName);
			if (listProjectRequests.getContent().isEmpty() || listProjectRequests.getContent() == null) {
				buildCustomException(KeyConstants.ERROR_LIST_PROJECT_REQUEST_EMPTY,
						KeyConstants.ERROR_CODE_LIST_PROJECT_REQUEST_EMPTY);
			}
			listProjectRequestsResponse = new ListProjectRequestsResponse();
			listProjectRequestsResponse.setListProjectRequests(listProjectRequests.getContent());
			listProjectRequestsResponse.setCurrentPage(listProjectRequests.getNumber());
			listProjectRequestsResponse.setTotalElements(listProjectRequests.getTotalElements());
			listProjectRequestsResponse.setTotalPages(listProjectRequests.getTotalPages());
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
		return listProjectRequestsResponse;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void approvalProject(ApprovalRequest approvalRequest) throws ProjectManagementException {
		try {

			for (ProjectRequest projectRequest : approvalRequest.getListProjectRequests()) {
				if (projectRequest.getStateProjectRequest().getStateProjectRequestId()
						.equals(KeyConstants.PENDING_STATE)) {
					projectRequestRepository.updateProjectRequest(KeyConstants.APPROVAL_STATE,
							approvalRequest.getDetails(), projectRequest.getProjectRequestId());
					projectRepository.updateStateProject(KeyConstants.AVALAIBLE_STATE,
							projectRequest.getProject().getProjectId());
					AssociatedUserProjectRequest associatedUserProjectRequest = new AssociatedUserProjectRequest();
					associatedUserProjectRequest.setProjectId(projectRequest.getProject().getProjectId());
					associatedUserProjectRequest.setUserName(projectRequest.getUserapp().getUserName());
					this.associateUser(associatedUserProjectRequest);
					associatedUserProjectRequest.setUserName(approvalRequest.getProjectDirector());
					this.associateUser(associatedUserProjectRequest);
				} else {
					buildCustomException(KeyConstants.ERROR_APPROVAL_DECLINE_PROJECTS,
							KeyConstants.ERROR_CODE_APPROVAL_DECLINE_PROJECTS);
				}

			}
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void declineProject(DeclineRequest declineRequest) throws ProjectManagementException {
		try {
			for (ProjectRequest projectRequest : declineRequest.getListProjectRequests()) {
				if (projectRequest.getStateProjectRequest().getStateProjectRequestId()
						.equals(KeyConstants.PENDING_STATE)) {
					projectRequestRepository.updateProjectRequest(KeyConstants.DECLINED_STATE_PROJECT_REQUEST,
							declineRequest.getDetails(), projectRequest.getProjectRequestId());
					projectRepository.updateStateProject(KeyConstants.DECLINED_STATE,
							projectRequest.getProject().getProjectId());
				} else {
					buildCustomException(KeyConstants.ERROR_APPROVAL_DECLINE_PROJECTS,
							KeyConstants.ERROR_CODE_APPROVAL_DECLINE_PROJECTS);
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
