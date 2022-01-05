package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;
import java.util.List;

import co.edu.usbcali.projectmanager.model.entities.ProjectRequest;

public class ListProjectRequestsResponse implements Serializable {

	private List<ProjectRequest> projectRequests;

	public List<ProjectRequest> getProjectRequests() {
		return projectRequests;
	}

	public void setProjectRequests(List<ProjectRequest> projectRequests) {
		this.projectRequests = projectRequests;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 193729508237384498L;

}
