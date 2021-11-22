package co.edu.usbcali.projectmanager.business.interfaces;

import java.sql.SQLException;

import co.edu.usbcali.projectmanager.model.excepcion.ProjectManagerExcepcion;

import co.edu.usbcali.projectmanager.model.request.ProjectRequest;

public interface IProjectService {

	public void createProject (ProjectRequest projectReq) throws ProjectManagerExcepcion, SQLException; 
  
	public void createProject (ProjectRequest projectReq); 

}
