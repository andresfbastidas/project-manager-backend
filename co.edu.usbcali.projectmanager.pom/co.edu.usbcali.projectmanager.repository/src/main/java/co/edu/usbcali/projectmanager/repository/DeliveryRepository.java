package co.edu.usbcali.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.entities.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
	
	public Delivery findByDeliveryId(Long deliveryId);

}
