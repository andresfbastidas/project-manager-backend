package co.edu.usbcali.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	public Project findByProjectId(Long projectId);

	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE public.project pj\n" + "	SET state_id=?1\n" + "	WHERE pj.project_id=?2", nativeQuery = true)
	public void updateStateProject(Long stateId, Long projectId) throws ProjectManagementException;

}
