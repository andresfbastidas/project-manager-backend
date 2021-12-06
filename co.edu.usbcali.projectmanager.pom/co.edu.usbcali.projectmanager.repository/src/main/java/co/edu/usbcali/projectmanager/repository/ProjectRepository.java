package co.edu.usbcali.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	@Query(value = "select nextval('project_seq')", nativeQuery = true)
    public Long getNextValProject();
}
