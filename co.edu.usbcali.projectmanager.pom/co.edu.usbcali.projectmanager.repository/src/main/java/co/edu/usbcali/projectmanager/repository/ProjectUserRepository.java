package co.edu.usbcali.projectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.entities.ProjectUser;

@Repository
public interface ProjectUserRepository extends JpaRepository<ProjectUser, Long> {

	@Query(value = "select * from public.project_user p where p.user_id = ?1 and p.project_id = ?2", nativeQuery = true)
	public ProjectUser findUserExists(Long userId, Long projectId);
}
