package co.edu.usbcali.projectmanager.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the state_project_request database table.
 * 
 */
@Entity
@Table(name="state_project_request")
@NamedQuery(name="StateProjectRequest.findAll", query="SELECT s FROM StateProjectRequest s")
public class StateProjectRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="state_project_request_id")
	private Long stateProjectRequestId;

	@Column(name="state_name_project_request")
	private String stateNameProjectRequest;

	//bi-directional many-to-one association to ProjectRequest
	@OneToMany(mappedBy="stateProjectRequest")
	private List<ProjectRequest> projectRequests;

	public StateProjectRequest() {
	}

	public Long getStateProjectRequestId() {
		return this.stateProjectRequestId;
	}

	public void setStateProjectRequestId(Long stateProjectRequestId) {
		this.stateProjectRequestId = stateProjectRequestId;
	}

	public String getStateNameProjectRequest() {
		return this.stateNameProjectRequest;
	}

	public void setStateNameProjectRequest(String stateNameProjectRequest) {
		this.stateNameProjectRequest = stateNameProjectRequest;
	}

	public List<ProjectRequest> getProjectRequests() {
		return this.projectRequests;
	}

	public void setProjectRequests(List<ProjectRequest> projectRequests) {
		this.projectRequests = projectRequests;
	}

	public ProjectRequest addProjectRequest(ProjectRequest projectRequest) {
		getProjectRequests().add(projectRequest);
		projectRequest.setStateProjectRequest(this);

		return projectRequest;
	}

	public ProjectRequest removeProjectRequest(ProjectRequest projectRequest) {
		getProjectRequests().remove(projectRequest);
		projectRequest.setStateProjectRequest(null);

		return projectRequest;
	}

}