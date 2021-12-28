package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;
import java.util.List;

import co.edu.usbcali.projectmanager.model.entities.Activity;

public class ListActivitiesResponse implements Serializable {

	List<Activity> listActivities;

	public List<Activity> getListActivities() {
		return listActivities;
	}

	public void setListActivities(List<Activity> listActivities) {
		this.listActivities = listActivities;
	}

	private static final long serialVersionUID = 2936480079133667095L;

}
