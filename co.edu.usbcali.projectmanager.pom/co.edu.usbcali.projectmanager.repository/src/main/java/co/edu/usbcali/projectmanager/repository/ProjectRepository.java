package co.edu.usbcali.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	public Project findByProjectId(Long projectId);

	@Query(value = "SELECT * FROM public.project p where p.state_id =?1", nativeQuery = true)
	public List<Project> findAllByProjectState(Long stateId);

}
