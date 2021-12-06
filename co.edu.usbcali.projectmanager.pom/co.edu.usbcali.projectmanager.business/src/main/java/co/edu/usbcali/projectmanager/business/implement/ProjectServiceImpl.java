package co.edu.usbcali.projectmanager.business.implement;

import java.util.Date;
import java.util.List;

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
import co.edu.usbcali.projectmanager.model.entities.State;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.ProjectRequest;
import co.edu.usbcali.projectmanager.repository.ProjectDeliveryRepository;
import co.edu.usbcali.projectmanager.repository.ProjectRepository;

@Service
public class ProjectServiceImpl extends ServiceUtils implements IProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ProjectDeliveryRepository projectDeliveryRepository;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void createProject(ProjectRequest projectRequest) throws ProjectManagementException {
		try {
			Project project = buildProject(projectRequest.getProject().getDateFrom(),
					projectRequest.getProject().getDateUntil(), projectRequest.getProject().getProjectTitle(),
					projectRequest.getProject().getGeneralObjetive(), projectRequest.getProject().getProjectSummary(),
					projectRequest.getProject().getProjectMethology(),
					projectRequest.getProject().getSpecificObjetive(), projectRequest.getProject().getJustification(),
					projectRequest.getProject().getProjectResearchTypologyId());

			ProjectDelivery projectDelivery = this.saveProjectDelivery(projectRequest.getDeliveries(), project);
			projectRepository.save(project);
			projectDeliveryRepository.save(projectDelivery);

		} catch (Exception e) {
			throw e;
		}

	}

	public ProjectDelivery saveProjectDelivery(List<Delivery> listDeliveries, Project project) {
		ProjectDelivery projectDelivery = new ProjectDelivery();
		for (Delivery delivery : listDeliveries) {
			projectDelivery.setDelivery(delivery);
			projectDelivery.setProject(project);
		}

		return projectDelivery;

	}

	private Project buildProject(Date dateFrom, Date dateUntil, String projectTitle, String generalObjetive,
			String projectSummary, String projectMethology, String specificObjetive, String justification,
			Long projectResearchId) {
		Project project = new Project();
		State state = new State();
		state.setStateId(KeyConstants.DEFAULT_STATE);
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
