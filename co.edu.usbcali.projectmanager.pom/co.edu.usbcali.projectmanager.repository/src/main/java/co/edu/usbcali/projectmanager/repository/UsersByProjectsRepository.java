package co.edu.usbcali.projectmanager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.dto.UsersByProjectDTO;

@Repository
public interface UsersByProjectsRepository extends JpaRepository<UsersByProjectDTO, Long> {

	@Query(value = "SELECT us.user_name, first_name, second_name, surname, second_surname, profile_id,\n"
			+ "    us.first_name ||' '|| us.surname as FullName\n"
			+ "	FROM public.userapp us inner join project_user pj on pj.user_name = us.user_name\n"
			+ "	inner join project pr on pr.project_id = pj.project_id and pr.project_id=?1", nativeQuery = true)
	public Page<UsersByProjectDTO> listAllUsersByProject(Pageable pageable, Long projectId);
}
