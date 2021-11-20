package co.edu.usbcali.projectmanager.business.implement;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.projectmanager.business.interfaces.IProjectService;
import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.entities.State;
import co.edu.usbcali.projectmanager.model.request.ProjectRequest;
import co.edu.usbcali.projectmanager.persistence.ProjectPersist;

@Service
public class ProjectServiceImpl implements IProjectService {

	private ProjectPersist projectPersist;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void createProject(ProjectRequest projectRequest) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Project project = this.buildProject(projectRequest.getProject().getDateFrom(),
				projectRequest.getProject().getDateUntil(), projectRequest.getProject().getSpecificObjetive(),
				projectRequest.getProject().getGeneralObjetive(), projectRequest.getProject().getProjectSummary(),
				projectRequest.getProject().getProjectTitle(), projectRequest.getState().getDescriptionState());

		projectPersist.save(project);
	}

	private Project buildProject(Date dateFrom, Date dateUntil, String specificObjetive, String generalObjetive,
			String projectSummary, String projectTitle, String stateDescription) {
		Project project = new Project();
		State state = new State();
		state.setDescriptionState(stateDescription);
		project.setDateFrom(dateFrom);
		project.setDateUntil(dateUntil);
		project.setProjectSummary(projectSummary);
		project.setSpecificObjetive(specificObjetive);
		project.setGeneralObjetive(generalObjetive);
		project.setProjectTitle(projectTitle);
		project.setState(state);
		return project;
	}

}
