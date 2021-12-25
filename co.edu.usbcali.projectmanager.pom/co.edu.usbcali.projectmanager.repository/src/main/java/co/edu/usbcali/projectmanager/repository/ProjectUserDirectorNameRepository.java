package co.edu.usbcali.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.dto.ProjectUserDirectorNameDTO;

@Repository
public interface ProjectUserDirectorNameRepository extends JpaRepository<ProjectUserDirectorNameDTO, Long> {

	@Query(value = "select pj.project_id, pj.date_from, pj.date_until, pj.project_title, pj.general_objetive, pj.project_summary, pj.project_methology, pj.specific_objetive, pj.justification, pj.project_research_typology_id, pj.state_id, pj.project_director, DIRECTOR.first_name ||' '|| DIRECTOR.surname as DirectorName from project_user pu, userapp up, project pj,(select user_name, first_name, surname from userapp where profile_id = ?1) DIRECTOR where pu.user_id = up.user_id and pj.project_id = pu.project_id and up.user_name = ?2 and pj.project_director = DIRECTOR.user_name", nativeQuery = true)
	public List<ProjectUserDirectorNameDTO> findAllProjectsByUserName(Long profileId, String userName);
}
