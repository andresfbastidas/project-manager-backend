package co.edu.usbcali.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.entities.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

	public Delivery findByDeliveryId(Long deliveryId);

	@Query(value = "select * from delivery", nativeQuery = true)
	public List<Delivery> findAllDeliveriesList();

}
