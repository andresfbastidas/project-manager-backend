package co.edu.usbcali.projectmanager.business.interfaces;

import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.ActivityRequest;

public interface IActivityService {

	public void createActivity(ActivityRequest activityRequest) throws ProjectManagementException; 
}
