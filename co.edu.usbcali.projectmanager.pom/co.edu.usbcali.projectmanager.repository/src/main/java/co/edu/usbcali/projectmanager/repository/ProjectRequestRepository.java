package co.edu.usbcali.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import co.edu.usbcali.projectmanager.model.entities.ProjectRequest;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;

public interface ProjectRequestRepository extends JpaRepository<ProjectRequest, Long> {

	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE public.project_request pr\n" + "	SET state_project_request_id=?1, details=?2\n"
			+ "	WHERE pr.project_request_id=?3", nativeQuery = true)
	public void updateProjectRequest(Long stateProjectRequestId, String details, Long projectRequestId)
			throws ProjectManagementException;

	public ProjectRequest findByProjectRequestId(Long projectId);

}
