package co.edu.usbcali.projectmanager.model.request;

import java.io.Serializable;

public class AssociatedUserProjectRequest implements Serializable {

	private String userName;

	private Long projectId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
	private static final long serialVersionUID = 1L;

}
