package co.edu.usbcali.projectmanager.model.request;

import java.io.Serializable;
import java.util.List;

import co.edu.usbcali.projectmanager.model.entities.ProjectRequest;

public class DeclineRequest implements Serializable {

	private List<ProjectRequest> listProjectRequests;

	private String details;

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<ProjectRequest> getListProjectRequests() {
		return listProjectRequests;
	}

	public void setListProjectRequests(List<ProjectRequest> listProjectRequests) {
		this.listProjectRequests = listProjectRequests;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
