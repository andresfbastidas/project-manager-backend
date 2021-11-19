package co.edu.usbcali.projectmanager.model.entities;

import java.io.Serializable;

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


/**
 * The persistent class for the "Project_User" database table.
 * 
 */
@Entity
@Table(name="Project_User")
@NamedQuery(name="Project_User.findAll", query="SELECT p FROM Project_User p")
public class ProjectUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROJECTUSERID_GENERATOR", sequenceName="PROJECT_USER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECTUSERID_GENERATOR")
	@Column(name="project_user_id")
	private Long projectUserId;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}