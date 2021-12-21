package co.edu.usbcali.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.projectmanager.model.entities.ProjectRequest;

public interface ProjectRequestRepository extends JpaRepository<ProjectRequest, Long> {
	

}
