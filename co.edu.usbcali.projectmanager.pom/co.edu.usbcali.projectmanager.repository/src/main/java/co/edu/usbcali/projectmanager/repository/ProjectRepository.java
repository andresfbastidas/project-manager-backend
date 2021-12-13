package co.edu.usbcali.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	public Project findByProjectId(Long projectId);
}