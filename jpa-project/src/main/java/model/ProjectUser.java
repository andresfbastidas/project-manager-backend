package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the project_user database table.
 * 
 */
@Entity
@Table(name="project_user")
@NamedQuery(name="ProjectUser.findAll", query="SELECT p FROM ProjectUser p")
public class ProjectUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROJECT_USER_PROJECTUSERID_GENERATOR", sequenceName="PROJECT_USER_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECT_USER_PROJECTUSERID_GENERATOR")
	@Column(name="project_user_id")
	private Long projectUserId;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;

	//bi-directional many-to-one association to Userapp
	@ManyToOne
	@JoinColumn(name="user_id")
	private Userapp userapp;

	public ProjectUser() {
	}

	public Long getProjectUserId() {
		return this.projectUserId;
	}

	public void setProjectUserId(Long projectUserId) {
		this.projectUserId = projectUserId;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Userapp getUserapp() {
		return this.userapp;
	}

	public void setUserapp(Userapp userapp) {
		this.userapp = userapp;
	}

}