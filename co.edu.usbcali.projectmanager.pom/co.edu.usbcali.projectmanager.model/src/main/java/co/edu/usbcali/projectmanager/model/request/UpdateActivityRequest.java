package co.edu.usbcali.projectmanager.model.request;

import java.io.Serializable;

public class UpdateActivityRequest implements Serializable {

	private Long activityId;

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
