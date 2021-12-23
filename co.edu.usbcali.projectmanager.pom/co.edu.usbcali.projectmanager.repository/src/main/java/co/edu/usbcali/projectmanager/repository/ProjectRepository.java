package co.edu.usbcali.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	public Project findByProjectId(Long projectId);
	
	@Query(value ="SELECT * FROM public.project p where p.state_id =?1", nativeQuery = true)
	public List<Project> findAllByProjectState(Long stateId);
	
	@Query(value ="select pj.project_id, pj.date_from, pj.date_until, pj.project_title, \n"
			+ "pj.general_objetive, pj.project_summary, pj.project_methology, pj.specific_objetive, \n"
			+ "pj.justification, pj.project_research_typology_id, pj.state_id from project pj, project_user pu, userapp up\n"
			+ "where pj.project_id = pu.project_id and pu.user_id = up.user_id\n"
			+ "and up.user_name = ?1", nativeQuery = true)
	public List<Project> findAllProjectsByUserName(String userName);
}
