package co.edu.usbcali.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.projectmanager.model.entities.StateProjectRequest;

public interface StateProjectRequestRepository extends JpaRepository<StateProjectRequest, Long> {

}
