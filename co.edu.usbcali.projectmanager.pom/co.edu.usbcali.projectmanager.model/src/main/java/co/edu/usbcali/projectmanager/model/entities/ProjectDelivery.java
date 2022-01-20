package co.edu.usbcali.projectmanager.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the project_delivery database table.
 * 
 */
@Entity
@Table(name="project_delivery")
@NamedQuery(name="ProjectDelivery.findAll", query="SELECT p FROM ProjectDelivery p")
public class ProjectDelivery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROJECT_DELIVERY_PROJECTDELIVERYID_GENERATOR", sequenceName="PROJECTDELIVERY_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECT_DELIVERY_PROJECTDELIVERYID_GENERATOR")
	@Column(name="project_delivery_id")
	private Long projectDeliveryId;

	//bi-directional many-to-one association to Delivery
	@ManyToOne
	@JoinColumn(name="delivery_id")
	private Delivery delivery;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;

	public ProjectDelivery() {
	}

	public Long getProjectDeliveryId() {
		return this.projectDeliveryId;
	}

	public void setProjectDeliveryId(Long projectDeliveryId) {
		this.projectDeliveryId = projectDeliveryId;
	}

	public Delivery getDelivery() {
		return this.delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}