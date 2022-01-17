package co.edu.usbcali.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.usbcali.projectmanager.model.dto.ProjectRequestInfoDTO;

public interface ProjectRequestInfoRepository extends JpaRepository<ProjectRequestInfoDTO, Long> {

	@Query(value = "select pr.project_request_id,pj.project_id,pj.date_from,pj.date_until, \n"
			+ "pj.project_title,pj.general_objetive, pj.project_summary, pj.project_methology, \n"
			+ "pj.specific_objetive, pj.justification, pr.details, rt.typology_description,\n"
			+ "DELIVERYS, pj.create_by from project_request pr, project pj, \n"
			+ "state_project_request sr,research_typology rt,\n"
			+ "(SELECT pd.project_id,array_to_string(array_agg(d.delivery_name),',') AS DELIVERYS\n"
			+ "FROM project_delivery pd, delivery d, project pj WHERE pd.project_id=pj.project_id \n"
			+ " and d.delivery_id= pd.delivery_id GROUP BY pd.project_id) DELIVERYS\n"
			+ "where pr.project_id=pj.project_id and  DELIVERYS.project_id=pr.project_id \n"
			+ "and pj.project_research_typology_id = rt.project_research_typology_id and\n"
			+ "sr.state_project_request_id= pr.state_project_request_id and pr.project_request_id=?1", nativeQuery = true)
	public ProjectRequestInfoDTO findByRequestId(Long projectRequestId);
}
