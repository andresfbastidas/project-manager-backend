package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the state database table.
 * 
 */
@Entity
@Table(name="State")
@NamedQuery(name="State.findAll", query="SELECT s FROM State s")
public class State implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STATE_STATEID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STATE_STATEID_GENERATOR")
	@Column(name="state_id")
	private Long stateId;

	@Column(name="state_name")
	private String stateName;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="state")
	private List<Project> projects;

	public State() {
	}

	public Long getStateId() {
		return this.stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
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