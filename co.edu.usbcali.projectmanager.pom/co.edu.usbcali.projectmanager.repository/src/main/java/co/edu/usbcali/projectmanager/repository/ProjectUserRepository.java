package co.edu.usbcali.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.entities.ProjectUser;

@Repository
public interface ProjectUserRepository extends JpaRepository<ProjectUser, Long> {

	@Query(value = "select * from public.project_user p inner join userapp u ON p.user_id = u.user_id\n"
			+ "	and u.user_name = ?1 inner join project pr ON p.project_id = pr.project_id\n"
			+ "	and pr.project_id = ?2", nativeQuery = true)
	public ProjectUser findUserExists(String userName, Long projectId);
	
	@Query(value = "select p.project_user_id, p.project_id, p.user_id, u.user_name, u.profile_id from public.project_user p inner join userapp u ON p.user_id = u.user_id\n"
			+ "			inner join project pr ON p.project_id = pr.project_id\n"
			+ "			and u.profile_id = ?1 and pr.project_id= ?2", nativeQuery = true)
	public ProjectUser findExistsMoreDirectors(Long profileId, Long projectId);
	
	
}
