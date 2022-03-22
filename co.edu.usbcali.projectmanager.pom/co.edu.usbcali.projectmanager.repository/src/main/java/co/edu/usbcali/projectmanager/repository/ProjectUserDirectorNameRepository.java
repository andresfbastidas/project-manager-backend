package co.edu.usbcali.projectmanager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.dto.ProjectUserDirectorNameDTO;

@Repository
public interface ProjectUserDirectorNameRepository extends JpaRepository<ProjectUserDirectorNameDTO, Long> {

	@Query(value = "select pj.project_id, pj.date_from, pj.date_until, pj.project_title,\n"
			+ "			pj.general_objetive, pj.project_summary, pj.project_methology, pj.specific_objetive,\n"
			+ "			pj.justification, pj.project_research_typology_id, pj.state_id, pj.project_director, DIRECTOR.first_name ||' '|| DIRECTOR.surname as DirectorName,\n"
			+ "			pj.create_by,USERS, CREATE_BY.first_name ||' '|| CREATE_BY.surname AS CREATE_BY_NAMES\n"
			+ "			from project_user pu, userapp up, project pj,(select user_name, first_name, surname from userapp where profile_id = ?1) DIRECTOR,\n"
			+ "			(SELECT pju.project_id,\n"
			+ "			array_to_string(array_agg(usr.first_name ||' '|| usr.surname),',') AS USERS\n"
			+ "			FROM project_user pju, userapp usr, project pj WHERE pju.project_id=pj.project_id and\n"
			+ "			usr.user_name= pju.user_name\n" + "			GROUP BY pju.project_id) USERS,\n"
			+ "			(select usw.user_name,usw.first_name, usw.surname from userapp usw where usw.user_name=?2) CREATE_BY\n"
			+ "			where pu.user_name = up.user_name and pj.project_id = pu.project_id and up.user_name = CREATE_BY.user_name\n"
			+ "			and pj.project_director = DIRECTOR.user_name and USERS.project_id=pj.project_id", nativeQuery = true)
	public Page<ProjectUserDirectorNameDTO> findAllProjectsByUserNameDTO(Pageable pageable, Long profileId,
			String userName);
}
