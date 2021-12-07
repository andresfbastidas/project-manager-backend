package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the delivery database table.
 * 
 */
@Entity
@Table(name="Delivery")
@NamedQuery(name="Delivery.findAll", query="SELECT d FROM Delivery d")
public class Delivery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DELIVERY_DELIVERYID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DELIVERY_DELIVERYID_GENERATOR")
	@Column(name="delivery_id")
	private Long deliveryId;

	@Column(name="delivery_name")
	private String deliveryName;

	@Column(name="delivery_type")
	private String deliveryType;

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

	public String getDeliveryName() {
		return this.deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryType() {
		return this.deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
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