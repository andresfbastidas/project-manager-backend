package co.edu.usbcali.projectmanager.business.implement;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.projectmanager.business.interfaces.IActivityService;
import co.edu.usbcali.projectmanager.business.interfaces.IProjectService;
import co.edu.usbcali.projectmanager.business.utils.ServiceUtils;
import co.edu.usbcali.projectmanager.model.constant.KeyConstants;
import co.edu.usbcali.projectmanager.model.entities.Activity;
import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.entities.StateActivity;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.ActivityRequest;
import co.edu.usbcali.projectmanager.repository.ActivityRepository;

@Service
public class ActivityServiceImpl extends ServiceUtils implements IActivityService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	private static final String CLASS_NAME = "ActivityServiceImpl";

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private IProjectService projectService;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void createActivity(ActivityRequest activityRequest) throws ProjectManagementException {
		Project project = null;
		try {
			project = projectService.findByProjectId(activityRequest.getActivity().getProject().getProjectId());
			Activity activity = this.buildActivity(activityRequest.getActivity().getActivityName(),
					activityRequest.getActivity().getStateActivity(), activityRequest.getActivity().getDateFrom(),
					activityRequest.getActivity().getDateUntil(), project,
					activityRequest.getActivity().getAssignedUser());

			activityRepository.save(activity);

		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}

	}

	public Activity buildActivity(String activityName, StateActivity stateActivity, Date dateFrom, Date dateUntil,
			Project project, String assignedUser) {
		Activity activity = new Activity();
		activity.setActivityName(activityName);
		activity.setStateActivity(stateActivity);
		activity.setDateFrom(dateFrom);
		activity.setDateUntil(dateUntil);
		activity.setProject(project);
		activity.setAssignedUser(assignedUser);
		return activity;
	}

}
