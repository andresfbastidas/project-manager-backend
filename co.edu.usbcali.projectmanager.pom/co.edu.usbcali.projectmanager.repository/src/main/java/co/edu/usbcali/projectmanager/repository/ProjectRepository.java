package co.edu.usbcali.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	public Project findByProjectId(Long projectId);

	@Query(value = "SELECT * FROM public.project p where p.state_id =?1", nativeQuery = true)
	public List<Project> findAllByProjectState(Long stateId);

	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE public.project pj\n" + "	SET state_id=?1\n" + "	WHERE pj.project_id=?2", nativeQuery = true)
	public void updateStateProject(Long stateId,Long projectId) throws ProjectManagementException;
	
	@Modifying(clearAutomatically = true)
	@Query(value = "DELETE FROM public.project pj\n"
			+ "	WHERE pj.project_id=?1", nativeQuery = true)
	public void deleteProject(Long projectId) throws ProjectManagementException;

}
