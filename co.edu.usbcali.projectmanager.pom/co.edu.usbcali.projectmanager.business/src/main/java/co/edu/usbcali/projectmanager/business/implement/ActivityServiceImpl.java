package co.edu.usbcali.projectmanager.business.implement;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import co.edu.usbcali.projectmanager.model.response.GenericListResponse;
import co.edu.usbcali.projectmanager.model.response.ListActivitiesResponse;
import co.edu.usbcali.projectmanager.model.response.ProjectResponse;
import co.edu.usbcali.projectmanager.repository.ActivityRepository;
import co.edu.usbcali.projectmanager.repository.StateActivityRepository;

@Service
public class ActivityServiceImpl extends ServiceUtils implements IActivityService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ActivityServiceImpl.class);

	private static final String CLASS_NAME = "ActivityServiceImpl";

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private IProjectService projectService;

	@Autowired
	private StateActivityRepository stateActivityRepository;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void createActivity(ActivityRequest activityRequest) throws ProjectManagementException {
		try {
			ProjectResponse projectResponse = new ProjectResponse();
			projectResponse = projectService.findByProjectId(activityRequest.getProjectId());
			if (projectResponse.getProject().getState().getStateId().equals(KeyConstants.FINISHED_STATE)
					|| projectResponse.getProject().getState().getStateId().equals(KeyConstants.DECLINED_STATE)
					|| projectResponse.getProject().getState().getStateId().equals(KeyConstants.SOLINI_STATE)) {
				buildCustomException(KeyConstants.ERROR_CODE_NOT_ASSOCIATED_USER_PROJECT,
						KeyConstants.ERROR_CREATE_ACTIVITY);
			}
			Activity activity = this.buildActivity(activityRequest.getActivity().getActivityName(),
					activityRequest.getActivity().getStateActivity(), activityRequest.getActivity().getDateFrom(),
					activityRequest.getActivity().getDateUntil(), projectResponse.getProject(),
					activityRequest.getActivity().getAssignedUser());

			activityRepository.save(activity);

		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}

	}

	@Override
	public GenericListResponse<StateActivity> findAllStatesActivities() throws ProjectManagementException {
		GenericListResponse<StateActivity> genericListResponse = null;
		List<StateActivity> listStateActivities = null;
		try {
			genericListResponse = new GenericListResponse<StateActivity>();
			listStateActivities = stateActivityRepository.findAll();
			if (listStateActivities.isEmpty() || listStateActivities == null) {
				buildCustomException(KeyConstants.ERROR_CODE_GENERIC_LIST_EMPTY, KeyConstants.GENERIC_LIST_EMPTY);
			}
			genericListResponse.setGenericList(listStateActivities);
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
		return genericListResponse;
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

	@Override
	public ListActivitiesResponse findActivitiesByProjectAndState(Pageable page, Long projectId, Long progressState,
			Long createState, Long finishedState) throws ProjectManagementException {
		Page<Activity> listActivities = null;
		ListActivitiesResponse listActivitiesResponse = null;
		try {
			listActivitiesResponse = new ListActivitiesResponse();
			listActivities = activityRepository.findActivitiesByProjectId(page, projectId, progressState, createState,
					finishedState);
			if (listActivities.getContent().isEmpty() || listActivities.getContent() == null) {
				buildCustomException(KeyConstants.ERROR_ACTIVITIES_LIST_NOT_FOUND,
						KeyConstants.ERROR_CODE_ACTIVITIES_NOT_FOUND);
			}
			listActivitiesResponse.setListActivities(listActivities.getContent());
			listActivitiesResponse.setCurrentPage(listActivities.getNumber());
			listActivitiesResponse.setTotalElements(listActivities.getTotalElements());
			listActivitiesResponse.setTotalPages(listActivities.getTotalPages());
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
		return listActivitiesResponse;
	}

	@Override
	public Activity findActivityById(Long activityId) throws ProjectManagementException {
		Activity activity = null;
		try {
			activity = activityRepository.findByActivityId(activityId);
			if (activity == null) {
				buildCustomException(KeyConstants.ERROR_FIND_ACTIVITY, KeyConstants.ERROR_CODE_FIND_ACTIVITY);
			}
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
		return activity;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateActivity(Long activityId) throws ProjectManagementException {
		Activity activity = null;
		try {
			activity = this.findActivityById(activityId);
			Date dateCurrent = Calendar.getInstance().getTime();
			if (activity.getStateActivity().getStateActivityId() == KeyConstants.CREATE_STATE_ACTIVITY) {
				activityRepository.updateStateActivityandDateUntil(dateCurrent, KeyConstants.PROGRESS_STATE_ACTIVITY,
						activity.getActivityId());
			} else if (activity.getStateActivity().getStateActivityId() == KeyConstants.PROGRESS_STATE_ACTIVITY) {
				activityRepository.updateStateActivityandDateFrom(dateCurrent, KeyConstants.FINISHED_STATE_ACTIVITY,
						activity.getActivityId());
			} else {
				buildCustomException(KeyConstants.ERROR_UPDATE_ACTIVITY, KeyConstants.ERROR_CODE_UPDATE_ACTIVITY);
			}
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}

	}

	@Override
	public void deleteActivity(Long activityId) throws ProjectManagementException {
		Activity activity = null;
		try {
			activity = this.findActivityById(activityId);
			if (!activity.getComments().isEmpty()) {
				buildCustomException(KeyConstants.ERROR_DELETE_ACTIVITY, KeyConstants.ERROR_CODE_DELETE_ACTIVITY);
			}
			activityRepository.delete(activity);
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}

	}

}
