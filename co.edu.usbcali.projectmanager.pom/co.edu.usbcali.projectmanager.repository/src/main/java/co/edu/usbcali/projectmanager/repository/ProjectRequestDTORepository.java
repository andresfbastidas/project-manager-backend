package co.edu.usbcali.projectmanager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.usbcali.projectmanager.model.dto.ProjectRequestDTO;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;

public interface ProjectRequestDTORepository extends JpaRepository<ProjectRequestDTO, Long> {

	@Query(value = "select distinct pr.project_request_id,pj.project_id,sr.state_project_request_id, \n"
			+ "pr.user_name, pr.details,sr.state_name_project_request, pj.project_director\n"
			+ "from project_request pr, project pj, state_project_request sr\n"
			+ "where (pr.state_project_request_id =?1 OR pr.state_project_request_id=?2 OR\n"
			+ "pr.state_project_request_id =?3) and \n"
			+ "pr.project_id=pj.project_id and pj.project_director=?4 and \n"
			+ "sr.state_project_request_id= pr.state_project_request_id", nativeQuery = true)
	public Page<ProjectRequestDTO> findProjectRequestByStateForDirector(Pageable pageable, Long stateApproval,
			Long stateDecline, Long statePending, String userName) throws ProjectManagementException;

	@Query(value = "select distinct pr.project_request_id,pj.project_id,sr.state_project_request_id, \n"
			+ "pr.user_name, pr.details,sr.state_name_project_request, pj.project_director\n"
			+ "from project_request pr, project pj, state_project_request sr\n"
			+ "where (pr.state_project_request_id =?1 OR pr.state_project_request_id=?2 OR\n"
			+ "pr.state_project_request_id =?3) and \n" + "pr.project_id=pj.project_id and pr.user_name=?4 and \n"
			+ "sr.state_project_request_id= pr.state_project_request_id", nativeQuery = true)
	public Page<ProjectRequestDTO> findProjectRequestByStateForUser(Pageable pageable, Long stateApproval,
			Long stateDecline, Long statePending, String userName) throws ProjectManagementException;
}
