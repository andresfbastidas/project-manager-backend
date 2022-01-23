package co.edu.usbcali.projectmanager.model.request;

import java.io.Serializable;
import java.util.ArrayList;

import co.edu.usbcali.projectmanager.model.entities.Delivery;
import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.entities.State;
import co.edu.usbcali.projectmanager.model.entities.Userapp;

public class UpdateProjectRequest implements Serializable {

	private Project project;

	private State state;

	private ArrayList<Delivery> deliveries;

	private Userapp userapp;

	private Long projectId;

	private Long projectRequestId;

	public Long getProjectRequestId() {
		return projectRequestId;
	}

	public void setProjectRequestId(Long projectRequestId) {
		this.projectRequestId = projectRequestId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public ArrayList<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(ArrayList<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	public Userapp getUserapp() {
		return userapp;
	}

	public void setUserapp(Userapp userapp) {
		this.userapp = userapp;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	private static final long serialVersionUID = 1L;

}
