package co.edu.usbcali.projectmanager.model.request;

import java.io.Serializable;

public class UpdateProjectState implements Serializable {

	private Long projectId;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	private static final long serialVersionUID = -2028852970248179201L;

}
