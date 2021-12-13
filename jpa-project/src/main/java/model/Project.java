package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@Table(name="Project")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROJECT_PROJECTID_GENERATOR", sequenceName="PROJECT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECT_PROJECTID_GENERATOR")
	@Column(name="project_id")
	private Long projectId;

	@Temporal(TemporalType.DATE)
	@Column(name="date_from")
	private Date dateFrom;

	@Temporal(TemporalType.DATE)
	@Column(name="date_until")
	private Date dateUntil;

	@Column(name="general_objetive")
	private String generalObjetive;

	private String justification;

	@Column(name="project_methology")
	private String projectMethology;

	@Column(name="project_research_typology_id")
	private Long projectResearchTypologyId;

	@Column(name="project_summay")
	private String projectSummay;

	@Column(name="project_title")
	private String projectTitle;

	@Column(name="specific_objetive")
	private String specificObjetive;

	//bi-directional many-to-one association to Activity
	@OneToMany(mappedBy="project")
	private List<Activity> activities;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="state_id")
	private State state;

	//bi-directional many-to-one association to ProjectDelivery
	@OneToMany(mappedBy="project")
	private List<ProjectDelivery> projectDeliveries;

	//bi-directional many-to-one association to ProjectUser
	@OneToMany(mappedBy="project")
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

	public String getProjectSummay() {
		return this.projectSummay;
	}

	public void setProjectSummay(String projectSummay) {
		this.projectSummay = projectSummay;
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