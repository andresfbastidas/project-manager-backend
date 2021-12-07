package co.edu.usbcali.projectmanager.model.request;

import java.io.Serializable;

import co.edu.usbcali.projectmanager.model.entities.Activity;

public class ActivityRequest implements Serializable {

	private Activity activity;

	private Long projectId;

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2639609634580449730L;

}
