package co.edu.usbcali.projectmanager.repository;

import java.util.Date;

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

	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE public.project SET state_id=?1, date_from=?2 WHERE project_id=?3", nativeQuery = true)
	public void updateStateProjectandDateFrom(Long stateId, Date dateFrom, Long projectId)
			throws ProjectManagementException;

	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE public.project SET state_id=?1, date_until=?2 WHERE project_id=?3", nativeQuery = true)
	public void updateStateProjectandDateUntil(Long stateId, Date dateUntil, Long projectId)
			throws ProjectManagementException;

}
