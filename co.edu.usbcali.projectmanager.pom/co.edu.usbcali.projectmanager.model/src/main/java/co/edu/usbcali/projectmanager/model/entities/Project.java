package co.edu.usbcali.projectmanager.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="project_seq" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="project_seq")
	@Column(name="project_id")
	private Long projectId;

	@Column(name="date_from")
	private Timestamp dateFrom;

	@Column(name="date_until")
	private Timestamp dateUntil;

	private String deliverables;

	@Column(name="specific_objetive")
	private String specificObjetive;

	@Column(name="general_objetive")
	private String generalObjetive;

	@Column(name="justification")
	private String justification;

	@Column(name="project_methology")
	private String projectMethology;

	@Column(name="project_state")
	private String projectState;

	@Column(name="project_summay")
	private String projectSummay;

	@Column(name="project_title")
	private String projectTitle;

	//bi-directional many-to-one association to Activity
	@OneToMany(mappedBy="project")
	private List<Activity> activities;

	//bi-directional many-to-one association to ProjectTypology
	@OneToMany(mappedBy="project")
	private List<ProjectTypology> projectTypologies;

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

	public String getDeliverables() {
		return this.deliverables;
	}

	public void setDeliverables(String deliverables) {
		this.deliverables = deliverables;
	}

	public String getSpecificObjetive() {
		return this.specificObjetive;
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

	public String getProjectState() {
		return this.projectState;
	}

	public void setProjectState(String projectState) {
		this.projectState = projectState;
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

	public List<ProjectTypology> getProjectTypologies() {
		return this.projectTypologies;
	}

	public void setProjectTypologies(List<ProjectTypology> projectTypologies) {
		this.projectTypologies = projectTypologies;
	}

	public ProjectTypology addProjectTypology(ProjectTypology projectTypology) {
		getProjectTypologies().add(projectTypology);
		projectTypology.setProject(this);

		return projectTypology;
	}

	public ProjectTypology removeProjectTypology(ProjectTypology projectTypology) {
		getProjectTypologies().remove(projectTypology);
		projectTypology.setProject(null);

		return projectTypology;
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