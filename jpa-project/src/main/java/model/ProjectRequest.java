package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the project_request database table.
 * 
 */
@Entity
@Table(name="project_request")
@NamedQuery(name="ProjectRequest.findAll", query="SELECT p FROM ProjectRequest p")
public class ProjectRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROJECT_REQUEST_PROJECTEQUESTID_GENERATOR", sequenceName="PROJECTREQUESTSEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECT_REQUEST_PROJECTEQUESTID_GENERATOR")
	@Column(name="project_equest_id")
	private Long projectEquestId;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;

	//bi-directional many-to-one association to StateProjectRequest
	@ManyToOne
	@JoinColumn(name="state_project_request_id")
	private StateProjectRequest stateProjectRequest;

	//bi-directional many-to-one association to Userapp
	@ManyToOne
	@JoinColumn(name="user_id")
	private Userapp userapp;

	public ProjectRequest() {
	}

	public Long getProjectEquestId() {
		return this.projectEquestId;
	}

	public void setProjectEquestId(Long projectEquestId) {
		this.projectEquestId = projectEquestId;
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