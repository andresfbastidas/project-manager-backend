package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Delivery" database table.
 * 
 */
@Entity
@Table(name="\"Delivery\"")
@NamedQuery(name="Delivery.findAll", query="SELECT d FROM Delivery d")
public class Delivery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="delivery_id")
	private Long deliveryId;

	@Column(name="delivery_name")
	private String deliveryName;

	@Column(name="delivery_type")
	private String deliveryType;

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

}