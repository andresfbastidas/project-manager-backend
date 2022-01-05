package co.edu.usbcali.projectmanager.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * The persistent class for the userapp database table.
 * 
 */
@Entity
@NamedQuery(name = "Userapp.findAll", query = "SELECT u FROM Userapp u")
public class Userapp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_name")
	private String userName;

	private String email;

	@Column(name = "first_name")
	private String firstName;

	private String password;

	@Column(name = "second_name")
	private String secondName;

	@Column(name = "second_surname")
	private String secondSurname;

	@Column(name = "surname")
	private String surname;

	// bi-directional many-to-one association to ProjectRequest
	@OneToMany(mappedBy = "userapp")
	@JsonIgnore
	private List<ProjectRequest> projectRequests;

	// bi-directional many-to-one association to ProjectUser
	@OneToMany(mappedBy = "userapp")
	@JsonIgnore
	private List<ProjectUser> projectUsers;

	// bi-directional many-to-one association to Profile
	@ManyToOne
	@JoinColumn(name = "profile_id")
	private Profile profile;

	public Userapp() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecondName() {
		return this.secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getSecondSurname() {
		return this.secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<ProjectRequest> getProjectRequests() {
		return this.projectRequests;
	}

	public void setProjectRequests(List<ProjectRequest> projectRequests) {
		this.projectRequests = projectRequests;
	}

	public ProjectRequest addProjectRequest(ProjectRequest projectRequest) {
		getProjectRequests().add(projectRequest);
		projectRequest.setUserapp(this);

		return projectRequest;
	}

	public ProjectRequest removeProjectRequest(ProjectRequest projectRequest) {
		getProjectRequests().remove(projectRequest);
		projectRequest.setUserapp(null);

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
		projectUser.setUserapp(this);

		return projectUser;
	}

	public ProjectUser removeProjectUser(ProjectUser projectUser) {
		getProjectUsers().remove(projectUser);
		projectUser.setUserapp(null);

		return projectUser;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}