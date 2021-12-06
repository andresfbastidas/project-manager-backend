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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * The persistent class for the "Project" database table.
 * 
 */
@Entity
@Table(name = "Project")
@NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PROJECTID_GENERATOR", sequenceName = "PROJECT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROJECTID_GENERATOR")
	@Column(name = "project_id")
	private Long projectId;

	@NotNull
	@Column(name = "date_from")
	private Date dateFrom;

	@NotNull
	@Column(name = "date_until")
	private Date dateUntil;

	@NotNull
	@Column(name = "specific_objetive")
	private String specificObjetive;

	@NotNull
	@Column(name = "general_objetive")
	private String generalObjetive;

	@NotNull
	@Column(name = "justification")
	private String justification;

	@NotNull
	@Column(name = "project_methology")
	private String projectMethology;

	@NotNull
	@Column(name = "project_research_typology_id")
	private Long projectResearchTypologyId;

	@NotNull
	@Column(name = "project_summary")
	private String projectSummary;

	@NotNull
	@Column(name = "project_title")
	private String projectTitle;

	// bi-directional many-to-one association to Activity
	@OneToMany(mappedBy = "project")
	private List<Activity> activities;

	// bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;

	// bi-directional many-to-one association to ProjectDelivery
	@OneToMany(mappedBy = "project")
	private List<ProjectDelivery> projectDeliveries;

	// bi-directional many-to-one association to ProjectUser
	@OneToMany(mappedBy = "project")
	private List<ProjectUser> projectUsers;

	public Project() {
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

	public String getSpecificObjetive() {
		return specificObjetive;
	}

	public void setSpecificObjetive(String specificObjetive) {
		this.specificObjetive = specificObjetive;
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