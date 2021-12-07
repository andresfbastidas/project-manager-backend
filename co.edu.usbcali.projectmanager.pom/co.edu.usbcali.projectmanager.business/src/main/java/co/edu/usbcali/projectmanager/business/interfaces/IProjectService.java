package co.edu.usbcali.projectmanager.business.interfaces;

import java.sql.SQLException;
import java.util.List;

import co.edu.usbcali.projectmanager.model.entities.Delivery;
import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.entities.ProjectDelivery;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.ProjectRequest;

public interface IProjectService {

	public void createProject (ProjectRequest projectReq) throws ProjectManagementException, SQLException; 

	public ProjectDelivery saveProjectDelivery(List<Delivery> listDeliveries, Project project) throws ProjectManagementException;
}
