package co.edu.usbcali.projectmanager.model.request;

import java.io.Serializable;

import co.edu.usbcali.projectmanager.model.entities.Project;

public class ProjectReq implements Serializable {

	private Project project;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	private static final long serialVersionUID = -5637996110817742373L;

}
