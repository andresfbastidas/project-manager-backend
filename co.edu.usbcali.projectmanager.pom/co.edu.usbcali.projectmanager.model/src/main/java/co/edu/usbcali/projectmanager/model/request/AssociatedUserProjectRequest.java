package co.edu.usbcali.projectmanager.model.request;

import java.io.Serializable;

import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.entities.Userapp;

public class AssociatedUserProjectRequest implements Serializable {

	private Userapp userapp;

	private Project project;

	public Userapp getUserapp() {
		return userapp;
	}

	public void setUserapp(Userapp userapp) {
		this.userapp = userapp;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
