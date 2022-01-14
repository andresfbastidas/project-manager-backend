package co.edu.usbcali.projectmanager.model.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The persistent class for the project_request database table.
 * 
 */
@Entity
@Table(name = "project_request")
@NamedQuery(name = "ProjectRequest.findAll", query = "SELECT p FROM ProjectRequest p")
public class ProjectRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PROJECT_REQUEST_PROJECTEQUESTID_GENERATOR", sequenceName = "PROJECTREQUESTSEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROJECT_REQUEST_PROJECTEQUESTID_GENERATOR")
	@Column(name = "project_request_id")
	@JsonProperty("projectRequestId")
	private Long projectRequestId;

	// bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	// bi-directional many-to-one association to StateProjectRequest
	@ManyToOne
	@JoinColumn(name = "state_project_request_id")
	private StateProjectRequest stateProjectRequest;

	@Column(name = "details")
	@JsonProperty("details")
	private String details;

	// bi-directional many-to-one association to Userapp
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_name")
	@JsonIgnore
	private Userapp userapp;
	
	@JsonProperty("projectId")
	private void setProyectId(Long projectId) {
	    this.project = new Project();
	    project.setProjectId(projectId);
	}
	
	@JsonProperty("userName")
	private void setUserName(String userName) {
	    this.userapp = new Userapp();
	    userapp.setUserName(userName);
	}
	
	@JsonProperty("stateProjectRequestId")
	@JoinColumn(name = "state_project_request_id")
	private void setStateRequestId(Long stateProjectRequestId) {
	    this.stateProjectRequest = new StateProjectRequest();
		stateProjectRequest.setStateProjectRequestId(stateProjectRequestId);
	}
	

	public ProjectRequest() {
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Long getProjectRequestId() {
		return this.projectRequestId;
	}

	public void setProjectRequestId(Long projectRequestId) {
		this.projectRequestId = projectRequestId;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public StateProjectRequest getStateProjectRequest() {
		return this.stateProjectRequest;
	}

	public void setStateProjectRequest(StateProjectRequest stateProjectRequest) {
		this.stateProjectRequest = stateProjectRequest;
	}

	public Userapp getUserapp() {
		return this.userapp;
	}

	public void setUserapp(Userapp userapp) {
		this.userapp = userapp;
	}

}