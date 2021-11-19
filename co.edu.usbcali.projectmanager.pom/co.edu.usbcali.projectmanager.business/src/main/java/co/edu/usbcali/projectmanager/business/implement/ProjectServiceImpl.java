package co.edu.usbcali.projectmanager.business.implement;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.projectmanager.business.interfaces.IProjectService;
import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.request.ProjectRequest;
import co.edu.usbcali.projectmanager.persistence.ProjectPersist;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	private ProjectPersist projectPersist;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void createProject (ProjectRequest projectReq) 
	{
		Project project = new Project();
		project.getProjectTitle();
		project.getDateFrom();
		project.getDateUntil();
		project.getSpecificObjetive();
		project.getGeneralObjetive();
		project.getJustification();
		project.getProjectMethology();
		project.getState().getDescriptionState();
		project.getProjectSummay();
		projectReq.setProject(project);
		projectPersist.save(project);
	}
	
}
