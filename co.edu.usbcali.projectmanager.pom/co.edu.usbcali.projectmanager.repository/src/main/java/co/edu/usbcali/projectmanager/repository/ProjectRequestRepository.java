package co.edu.usbcali.projectmanager.repository;

import java.util.List;

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

	@Query(value = "select pr.project_request_id,pj.project_id, pj.project_title, pj.project_summary, pj.specific_objetive, \n"
			+ "pj.general_objetive, pj.justification, pr.user_name, pr.details, sr.state_project_request_id,sr.state_project_request_id,sr.state_name_project_request\n"
			+ "from project_request pr, project pj, state_project_request sr, userapp usr \n"
			+ "where (pr.state_project_request_id =?1 OR pr.state_project_request_id=?2 OR \n"
			+ "	   pr.state_project_request_id =?3) and \n"
			+ "pr.project_id=pj.project_id and pj.project_director=?4 and \n"
			+ "sr.state_project_request_id= pr.state_project_request_id and usr.user_name=pr.user_name", nativeQuery = true)
	public List<ProjectRequest> findProjectRequestByStateForDirector(Long stateApproval, Long stateDecline,
			Long statePending, String userName) throws ProjectManagementException;

	@Query(value = "select pr.project_request_id,pj.project_id, pj.project_title, pj.project_summary, \n"
			+ "pj.specific_objetive,pj.general_objetive, pj.justification, pr.user_name, pr.details, \n"
			+ "sr.state_project_request_id,sr.state_project_request_id,sr.state_name_project_request\n"
			+ "from project_request pr, project pj, state_project_request sr, userapp usr\n"
			+ "where (pr.state_project_request_id =?1 OR pr.state_project_request_id=?2 OR\n"
			+ "pr.state_project_request_id =?3) and \n"
			+ "pr.project_id=pj.project_id and pr.user_name=?4 and \n"
			+ "sr.state_project_request_id= pr.state_project_request_id and usr.user_name=pr.user_name;", nativeQuery = true)
	public List<ProjectRequest> findProjectRequestByStateForUser(Long stateApproval, Long stateDecline,
			Long statePending, String userName) throws ProjectManagementException;

}
