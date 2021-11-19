package co.edu.usbcali.projectmanager.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "State" database table.
 * 
 */
@Entity
@Table(name="State")
@NamedQuery(name="State.findAll", query="SELECT s FROM State s")
public class State implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IDSTATE_GENERATOR", sequenceName="STATE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IDSTATE_GENERATOR")
	@Column(name="id_state")
	private Long idState;

	@Column(name="description_state")
	private String descriptionState;

	//bi-directional many-to-one association to Activity
	@OneToMany(mappedBy="state")
	private List<Activity> activities;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="state")
	private List<Project> projects;

	public State() {
	}

	public Long getIdState() {
		return this.idState;
	}

	public void setIdState(Long idState) {
		this.idState = idState;
	}

	public String getDescriptionState() {
		return this.descriptionState;
	}

	public void setDescriptionState(String descriptionState) {
		this.descriptionState = descriptionState;
	}

	public List<Activity> getActivities() {
		return this.activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public Activity addActivity(Activity activity) {
		getActivities().add(activity);
		activity.setState(this);

		return activity;
	}

	public Activity removeActivity(Activity activity) {
		getActivities().remove(activity);
		activity.setState(null);

		return activity;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setState(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setState(null);

		return project;
	}

}