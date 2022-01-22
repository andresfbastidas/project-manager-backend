package co.edu.usbcali.projectmanager.business.interfaces;

import co.edu.usbcali.projectmanager.model.entities.Activity;
import co.edu.usbcali.projectmanager.model.entities.StateActivity;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.ActivityRequest;
import co.edu.usbcali.projectmanager.model.response.GenericListResponse;
import co.edu.usbcali.projectmanager.model.response.ListActivitiesResponse;

public interface IActivityService {

	public void createActivity(ActivityRequest activityRequest) throws ProjectManagementException;

	public ListActivitiesResponse findActivitiesByProject(Long projectId) throws ProjectManagementException;

	public GenericListResponse<StateActivity> findAllStatesActivities() throws ProjectManagementException;

	public Activity findActivityById(Long activityId) throws ProjectManagementException;
}
