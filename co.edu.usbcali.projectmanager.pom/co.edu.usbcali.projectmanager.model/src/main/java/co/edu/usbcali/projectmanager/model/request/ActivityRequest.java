package co.edu.usbcali.projectmanager.model.request;

import java.io.Serializable;

import co.edu.usbcali.projectmanager.model.entities.Activity;

public class ActivityRequest implements Serializable {

	private Activity activity;

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2639609634580449730L;

}
