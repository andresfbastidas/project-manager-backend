package co.edu.usbcali.projectmanager.business.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.projectmanager.business.interfaces.IProjectService;
import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.request.ProjectReq;
import co.edu.usbcali.projectmanager.persistence.ProjectPersist;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	private ProjectPersist projectPersist;
	
	public void createProject (ProjectReq projectReq) 
	{
		Project project = new Project();
		project.getProjectTitle();
		project.getDateFrom();
		project.getDateUntil();
		project.getSpecificObjetive();
		project.getGeneralObjetive();
		project.getJustification();
		project.getProjectMethology();
		project.getProjectState();
		project.getProjectSummay();
		projectReq.setProject(project);
		projectPersist.save(project);
	}
	
}
