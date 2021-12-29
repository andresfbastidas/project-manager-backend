package co.edu.usbcali.projectmanager.model.request;

import java.io.Serializable;

import co.edu.usbcali.projectmanager.model.entities.ProjectRequest;

public class ApprovalDeclineRequest implements Serializable {

	private ProjectRequest projectRequest;

	public ProjectRequest getProjectRequest() {
		return projectRequest;
	}

	public void setProjectRequest(ProjectRequest projectRequest) {
		this.projectRequest = projectRequest;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2427873937620705090L;

}
