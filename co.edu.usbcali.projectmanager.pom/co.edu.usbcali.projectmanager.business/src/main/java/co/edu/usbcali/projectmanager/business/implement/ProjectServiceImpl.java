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
import co.edu.usbcali.projectmanager.model.entities.Delivery;
import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.entities.ProjectDelivery;
import co.edu.usbcali.projectmanager.model.entities.ProjectUser;
import co.edu.usbcali.projectmanager.model.entities.State;
import co.edu.usbcali.projectmanager.model.entities.Userapp;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.AssociatedUserProjectRequest;
import co.edu.usbcali.projectmanager.model.request.ProjectRequest;
import co.edu.usbcali.projectmanager.model.response.UserNameResponse;
import co.edu.usbcali.projectmanager.repository.ProjectDeliveryRepository;
import co.edu.usbcali.projectmanager.repository.ProjectRepository;
import co.edu.usbcali.projectmanager.repository.ProjectUserRepository;

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

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void createProject(ProjectRequest projectRequest) throws ProjectManagementException {
		try {
			Project project = buildProject(projectRequest.getProject().getDateFrom(),
					projectRequest.getProject().getDateUntil(), projectRequest.getProject().getProjectTitle(),
					projectRequest.getProject().getGeneralObjetive(), projectRequest.getProject().getProjectSummary(),
					projectRequest.getProject().getProjectMethology(),
					projectRequest.getProject().getSpecificObjetive(), projectRequest.getProject().getJustification(),
					projectRequest.getProject().getProjectResearchTypologyId(), projectRequest.getState());

			projectRepository.saveAndFlush(project);
			this.saveProjectDelivery(projectRequest.getDeliveries(), project);

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
				buildCustomException(KeyConstants.ERROR_CODE_PROJECT_NOT_SAVE, KeyConstants.PROJECT_NOT_SAVE);
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
				buildCustomException(KeyConstants.ERROR_CODE_PROJECT_NULL, KeyConstants.PROJECT_NOT_EXISTS);
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
			projectUser = projectUserRepository.findUserExists(userapp.getUserId(), project.getProjectId());
			if (projectUser != null) {
				buildCustomException(KeyConstants.ERROR_CODE_ASSOCIATED_PROJECT_USER,
						KeyConstants.ERROR_ASSOCIATED_PROJECT_USER_EXISTS);
			}
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

	private Project buildProject(Date dateFrom, Date dateUntil, String projectTitle, String generalObjetive,
			String projectSummary, String projectMethology, String specificObjetive, String justification,
			Long projectResearchId, State state) {
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
		return project;
	}

}
