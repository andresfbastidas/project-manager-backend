package co.edu.usbcali.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.entities.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
