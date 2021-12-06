package co.edu.usbcali.projectmanager.model.request;

import java.io.Serializable;
import java.util.List;

import co.edu.usbcali.projectmanager.model.entities.Delivery;
import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.entities.State;

public class ProjectRequest implements Serializable {

	private Project project;

	private State state;

	private Long deliveryId;

	private List<Delivery> deliveries;

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

	public Long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	private static final long serialVersionUID = -5637996110817742373L;

}
