package co.edu.usbcali.projectmanager.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the "Project" database table.
 * 
 */
@Entity
@Table(name="Project")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROJECTID_GENERATOR", sequenceName="PROJECT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECTID_GENERATOR")
	@Column(name="project_id")
	private Long projectId;

	@Column(name="date_from")
	private Timestamp dateFrom;

	@Column(name="date_until")
	private Timestamp dateUntil;

	@Column(name="especific_objetive")
	private String especificObjetive;

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

	public Timestamp getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(Timestamp dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Timestamp getDateUntil() {
		return this.dateUntil;
	}

	public void setDateUntil(Timestamp dateUntil) {
		this.dateUntil = dateUntil;
	}

	public String getEspecificObjetive() {
		return this.especificObjetive;
	}

	public void setEspecificObjetive(String especificObjetive) {
		this.especificObjetive = especificObjetive;
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