package co.edu.usbcali.projectmanager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.usbcali.projectmanager.model.dto.ProjectsListDTO;

public interface ProjectListRepository extends JpaRepository<ProjectsListDTO, Long> {

	@Query(value = "select distinct pj.project_id,pj.date_from,pj.date_until, \n"
			+ "pj.project_title,pj.general_objetive, pj.project_summary, pj.project_methology, \n"
			+ "pj.specific_objetive, pj.justification, rt.typology_description, pj.project_director,\n"
			+ "pj.investigation_problem, pj.create_by, s.state_name, DELIVERYS from project pj, \n"
			+ "state_project_request sr,research_typology rt, state s,\n"
			+ "(SELECT pd.project_id,array_to_string(array_agg(d.delivery_name),',') AS DELIVERYS\n"
			+ "FROM project_delivery pd, delivery d, project pj WHERE pd.project_id=pj.project_id \n"
			+ " and d.delivery_id= pd.delivery_id GROUP BY pd.project_id) DELIVERYS\n"
			+ "where DELIVERYS.project_id=pj.project_id \n"
			+ "and pj.project_research_typology_id = rt.project_research_typology_id and\n"
			+ "pj.state_id=s.state_id and pj.state_id=?1", nativeQuery = true)
	public Page<ProjectsListDTO> findAllByProjectState(Pageable pageable, Long stateId);
}
