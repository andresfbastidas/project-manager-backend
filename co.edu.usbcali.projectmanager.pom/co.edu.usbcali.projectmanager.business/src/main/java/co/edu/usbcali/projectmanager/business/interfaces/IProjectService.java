package co.edu.usbcali.projectmanager.business.interfaces;

import java.util.List;

import co.edu.usbcali.projectmanager.model.entities.Delivery;
import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.entities.ProjectDelivery;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.ProjectRequest;

public interface IProjectService {

	public void createProject (ProjectRequest projectReq) throws ProjectManagementException; 

	public ProjectDelivery saveProjectDelivery(List<Delivery> listDeliveries, Project project) throws ProjectManagementException;
	
	public Project findByProjectId (Long projectId) throws ProjectManagementException; 
}
