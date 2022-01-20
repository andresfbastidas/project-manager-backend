package co.edu.usbcali.projectmanager.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PROJECT_PROJECTID_GENERATOR", sequenceName = "PROJECT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROJECT_PROJECTID_GENERATOR")
	@Column(name = "project_id")
	private Long projectId;

	@Column(name = "date_from")
	private Date dateFrom;

	@Column(name = "date_until")
	private Date dateUntil;

	@Column(name = "general_objetive")
	private String generalObjetive;

	@Column(name = "justification")
	private String justification;

	@Column(name = "project_methology")
	private String projectMethology;

	@Column(name = "project_research_typology_id")
	private Long projectResearchTypologyId;

	@Column(name = "project_summary")
	private String projectSummary;

	@Column(name = "project_title")
	private String projectTitle;

	@Column(name = "specific_objetive")
	private String specificObjetive;

	@Column(name = "project_director")
	private String projectDirector;

	@Column(name = "create_by")
	private String createBy;

	// bi-directional many-to-one association to Activity
	@OneToMany(mappedBy = "project")
	@JsonIgnore
	private List<Activity> activities;

	// bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;

	// bi-directional many-to-one association to ProjectDelivery
	@OneToMany(mappedBy = "project")
	@JsonIgnore
	private List<ProjectDelivery> projectDeliveries;

	// bi-directional many-to-one association to ProjectRequest
	@OneToMany(mappedBy = "project")
	@JsonIgnore
	private List<ProjectRequest> projectRequests;

	// bi-directional many-to-one association to ProjectUser
	@OneToMany(mappedBy = "project")
	@JsonIgnore
	private List<ProjectUser> projectUsers;

	public Project() {
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Date getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateUntil() {
		return this.dateUntil;
	}

	public void setDateUntil(Date dateUntil) {
		this.dateUntil = dateUntil;
	}

	public String getGeneralObjetive() {
		return this.generalObjetive;
	}

	public void setGeneralObjetive(String generalObjetive) {
		this.generalObjetive = generalObjetive;
	}

	public String getJustification() {
		return this.justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getProjectMethology() {
		return this.projectMethology;
	}

	public void setProjectMethology(String projectMethology) {
		this.projectMethology = projectMethology;
	}

	public Long getProjectResearchTypologyId() {
		return this.projectResearchTypologyId;
	}

	public void setProjectResearchTypologyId(Long projectResearchTypologyId) {
		this.projectResearchTypologyId = projectResearchTypologyId;
	}

	public String getProjectSummary() {
		return this.projectSummary;
	}

	public void setProjectSummary(String projectSummary) {
		this.projectSummary = projectSummary;
	}

	public String getProjectTitle() {
		return this.projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getSpecificObjetive() {
		return this.specificObjetive;
	}

	public void setSpecificObjetive(String specificObjetive) {
		this.specificObjetive = specificObjetive;
	}

	public List<Activity> getActivities() {
		return this.activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public Activity addActivity(Activity activity) {
		getActivities().add(activity);
		activity.setProject(this);

		return activity;
	}

	public Activity removeActivity(Activity activity) {
		getActivities().remove(activity);
		activity.setProject(null);

		return activity;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getProjectDirector() {
		return projectDirector;
	}

	public void setProjectDirector(String projectDirector) {
		this.projectDirector = projectDirector;
	}

	public List<ProjectDelivery> getProjectDeliveries() {
		return this.projectDeliveries;
	}

	public void setProjectDeliveries(List<ProjectDelivery> projectDeliveries) {
		this.projectDeliveries = projectDeliveries;
	}

	public ProjectDelivery addProjectDelivery(ProjectDelivery projectDelivery) {
		getProjectDeliveries().add(projectDelivery);
		projectDelivery.setProject(this);

		return projectDelivery;
	}

	public ProjectDelivery removeProjectDelivery(ProjectDelivery projectDelivery) {
		getProjectDeliveries().remove(projectDelivery);
		projectDelivery.setProject(null);

		return projectDelivery;
	}

	public List<ProjectRequest> getProjectRequests() {
		return this.projectRequests;
	}

	public void setProjectRequests(List<ProjectRequest> projectRequests) {
		this.projectRequests = projectRequests;
	}

	public ProjectRequest addProjectRequest(ProjectRequest projectRequest) {
		getProjectRequests().add(projectRequest);
		projectRequest.setProject(this);

		return projectRequest;
	}

	public ProjectRequest removeProjectRequest(ProjectRequest projectRequest) {
		getProjectRequests().remove(projectRequest);
		projectRequest.setProject(null);

		return projectRequest;
	}

	public List<ProjectUser> getProjectUsers() {
		return this.projectUsers;
	}

	public void setProjectUsers(List<ProjectUser> projectUsers) {
		this.projectUsers = projectUsers;
	}

	public ProjectUser addProjectUser(ProjectUser projectUser) {
		getProjectUsers().add(projectUser);
		projectUser.setProject(this);

		return projectUser;
	}

	public ProjectUser removeProjectUser(ProjectUser projectUser) {
		getProjectUsers().remove(projectUser);
		projectUser.setProject(null);

		return projectUser;
	}

}