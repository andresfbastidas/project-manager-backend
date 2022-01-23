package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;
import java.util.List;

import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.entities.ProjectDelivery;

public class ProjectResponse implements Serializable {

	private Project project;

	private List<ProjectDelivery> projectDeliveries;

	public List<ProjectDelivery> getProjectDeliveries() {
		return projectDeliveries;
	}

	public void setProjectDeliveries(List<ProjectDelivery> projectDeliveries) {
		this.projectDeliveries = projectDeliveries;
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
	private static final long serialVersionUID = 854262120641965654L;

}
