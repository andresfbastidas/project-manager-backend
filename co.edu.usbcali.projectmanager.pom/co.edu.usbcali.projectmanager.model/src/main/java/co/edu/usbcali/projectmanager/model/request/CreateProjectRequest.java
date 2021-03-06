package co.edu.usbcali.projectmanager.model.request;

import java.io.Serializable;
import java.util.ArrayList;

import co.edu.usbcali.projectmanager.model.entities.Delivery;
import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.entities.State;
import co.edu.usbcali.projectmanager.model.entities.Userapp;

public class CreateProjectRequest implements Serializable {

	private Project project;

	private State state;

	private ArrayList<Delivery> deliveries;

	private Userapp userapp;

	public Userapp getUserapp() {
		return userapp;
	}

	public void setUserapp(Userapp userapp) {
		this.userapp = userapp;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public ArrayList<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(ArrayList<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	private static final long serialVersionUID = -5637996110817742373L;

}
