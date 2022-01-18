package co.edu.usbcali.projectmanager.model.request;

import java.io.Serializable;
import java.util.List;

import co.edu.usbcali.projectmanager.model.entities.ProjectRequest;

public class ApprovalRequest implements Serializable {

	private List<ProjectRequest> listProjectRequests;

	private String projectDirector;

	private String details;

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getProjectDirector() {
		return projectDirector;
	}

	public void setProjectDirector(String projectDirector) {
		this.projectDirector = projectDirector;
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
	private static final long serialVersionUID = -2427873937620705090L;

}
