package co.edu.usbcali.projectmanager.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.projectmanager.model.entities.Activity;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

	@Query(value = "select * from activity ac INNER JOIN project pj\n" + "ON ac.project_id = pj.project_id\n"
			+ "inner join state_activity st on st.state_activity_id = ac.state_activity_id\n"
			+ "and pj.project_id=?1 and (st.state_activity_id=?2 or st.state_activity_id=?3 or st.state_activity_id=?4)", nativeQuery = true)
	public Page<Activity> findActivitiesByProjectId(Pageable pageable, Long projectId, Long progressState,
			Long createState, Long finishedState);

	public Activity findByActivityId(Long activityId);

	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE public.activity\n" + "	SET date_from=?1, state_activity_id=?2\n"
			+ "	WHERE activity_id=?3", nativeQuery = true)
	public void updateStateActivityandDateFrom(Date dateFrom, Long stateActivityId, Long activityId)
			throws ProjectManagementException;

	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE public.activity\n" + "	SET date_until=?1, state_activity_id=?2\n"
			+ "	WHERE activity_id=?3", nativeQuery = true)
	public void updateStateActivityandDateUntil(Date dateUntil, Long stateActivityId, Long activityId)
			throws ProjectManagementException;
}
