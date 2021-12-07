package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the userapp database table.
 * 
 */
@Entity
@Table(name="Userapp")
@NamedQuery(name="Userapp.findAll", query="SELECT u FROM Userapp u")
public class Userapp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERAPP_USERID_GENERATOR", sequenceName="USER_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERAPP_USERID_GENERATOR")
	@Column(name="user_id")
	private Long userId;

	private String email;

	@Column(name="firts_name")
	private String firtsName;

	private String password;

	@Column(name="second_name")
	private String secondName;

	@Column(name="second_surname")
	private String secondSurname;

	private String surname;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_state")
	private String userState;

	//bi-directional many-to-one association to ProjectUser
	@OneToMany(mappedBy="userapp")
	private List<ProjectUser> projectUsers;

	//bi-directional many-to-one association to Profile
	@ManyToOne
	@JoinColumn(name="profile_id")
	private Profile profile;

	public Userapp() {
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirtsName() {
		return this.firtsName;
	}

	public void setFirtsName(String firtsName) {
		this.firtsName = firtsName;
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

	public String getUserState() {
		return this.userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
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