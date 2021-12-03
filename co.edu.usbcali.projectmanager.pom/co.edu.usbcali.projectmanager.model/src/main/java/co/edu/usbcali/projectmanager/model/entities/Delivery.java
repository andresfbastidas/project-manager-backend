package co.edu.usbcali.projectmanager.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Delivery" database table.
 * 
 */
@Entity
@Table(name="Delivery")
@NamedQuery(name="Delivery.findAll", query="SELECT d FROM Delivery d")
public class Delivery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="delivery_id")
	private Long deliveryId;

	@Column(name="delivery_name")
	private Long deliveryName;

	//bi-directional many-to-one association to ProjectDelivery
	@OneToMany(mappedBy="delivery")
	private List<ProjectDelivery> projectDeliveries;

	public Delivery() {
	}

	public Long getDeliveryId() {
		return this.deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public Long getDeliveryName() {
		return this.deliveryName;
	}

	public void setDeliveryName(Long deliveryName) {
		this.deliveryName = deliveryName;
	}

	public List<ProjectDelivery> getProjectDeliveries() {
		return this.projectDeliveries;
	}

	public void setProjectDeliveries(List<ProjectDelivery> projectDeliveries) {
		this.projectDeliveries = projectDeliveries;
	}

	public ProjectDelivery addProjectDelivery(ProjectDelivery projectDelivery) {
		getProjectDeliveries().add(projectDelivery);
		projectDelivery.setDelivery(this);

		return projectDelivery;
	}

	public ProjectDelivery removeProjectDelivery(ProjectDelivery projectDelivery) {
		getProjectDeliveries().remove(projectDelivery);
		projectDelivery.setDelivery(null);

		return projectDelivery;
	}

}