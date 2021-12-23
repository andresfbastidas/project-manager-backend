package co.edu.usbcali.projectmanager.business.interfaces;

import java.util.List;

import co.edu.usbcali.projectmanager.model.entities.Delivery;
import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.entities.ProjectDelivery;
import co.edu.usbcali.projectmanager.model.entities.Userapp;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.AssociatedUserProjectRequest;
import co.edu.usbcali.projectmanager.model.request.ProjectRequest;
import co.edu.usbcali.projectmanager.model.response.ProjectListResponse;

public interface IProjectService {

	public void createProject (ProjectRequest projectReq) throws ProjectManagementException; 

	public ProjectDelivery saveProjectDelivery(List<Delivery> listDeliveries, Project project) throws ProjectManagementException;
	
	public Project findByProjectId (Long projectId) throws ProjectManagementException; 
	
	public void associateUser (AssociatedUserProjectRequest associatedUserProject) throws ProjectManagementException; 
	
	public void saveProjectUser(Project project, Userapp userapp) throws ProjectManagementException;
	
	public ProjectListResponse<Project> findAllProjectByState() throws ProjectManagementException;
	
	public ProjectListResponse<Project> findAllProjectsByUserName(String userName) throws ProjectManagementException;
}
