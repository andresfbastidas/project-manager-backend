package co.edu.usbcali.projectmanager.model.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProjectRequestDTO implements Serializable {

	@Id
	@Column(name = "project_request_id")
	private Long projectRequestId;

	@Column(name = "project_id")
	private Long projectId;

	@Column(name = "state_project_request_id")
	private Long stateProjectRequestId;

	@Column(name = "state_name_project_request")
	private String stateNameProjectRequest;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "details")
	private String details;

	@Column(name = "project_director")
	private String projectDirector;

	public ProjectRequestDTO(Long projectRequestId, Long projectId, Long stateProjectRequestId,
			String stateNameProjectRequest, String userName, String details, String projectDirector) {
		super();
		this.projectRequestId = projectRequestId;
		this.projectId = projectId;
		this.stateProjectRequestId = stateProjectRequestId;
		this.stateNameProjectRequest = stateNameProjectRequest;
		this.userName = userName;
		this.details = details;
		this.projectDirector = projectDirector;
	}

	public ProjectRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getProjectDirector() {
		return projectDirector;
	}

	public void setProjectDirector(String projectDirector) {
		this.projectDirector = projectDirector;
	}

	public Long getProjectRequestId() {
		return projectRequestId;
	}

	public void setProjectRequestId(Long projectRequestId) {
		this.projectRequestId = projectRequestId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getStateProjectRequestId() {
		return stateProjectRequestId;
	}

	public void setStateProjectRequestId(Long stateProjectRequestId) {
		this.stateProjectRequestId = stateProjectRequestId;
	}

	public String getStateNameProjectRequest() {
		return stateNameProjectRequest;
	}

	public void setStateNameProjectRequest(String stateNameProjectRequest) {
		this.stateNameProjectRequest = stateNameProjectRequest;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	private static final long serialVersionUID = 5047931027239019823L;

}
