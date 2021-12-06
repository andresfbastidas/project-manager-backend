package co.edu.usbcali.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.entities.ProjectDelivery;

@Repository
public interface ProjectDeliveryRepository extends JpaRepository<ProjectDelivery, Long> {

}
