package co.edu.usbcali.projectmanager.business.interfaces;

import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.ActivityRequest;
import co.edu.usbcali.projectmanager.model.response.ListActivitiesResponse;

public interface IActivityService {

	public void createActivity(ActivityRequest activityRequest) throws ProjectManagementException;

	public ListActivitiesResponse findActivitiesByProject(Long projectId) throws ProjectManagementException;
}
