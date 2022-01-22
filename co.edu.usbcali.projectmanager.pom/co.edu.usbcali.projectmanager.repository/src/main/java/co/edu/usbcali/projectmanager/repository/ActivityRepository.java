package co.edu.usbcali.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.entities.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

	@Query(value = "SELECT *\n" + "	FROM public.activity ac\n" + "	where ac.project_id=?1", nativeQuery = true)
	public List<Activity> findActivitiesByProjectId(Long projectId);

	public Activity findByActivityId(Long activityId);
}
