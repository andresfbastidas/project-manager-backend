package co.edu.usbcali.projectmanager.model.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import co.edu.usbcali.projectmanager.model.entities.Profile;

@Entity
public class UsersByProjectDTO implements Serializable {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "second_name")
	private String secondName;

	@Column(name = "second_surname")
	private String secondSurname;

	@Column(name = "surname")
	private String surname;

	@Id
	@Column(name = "user_name")
	private String userName;

	@ManyToOne
	@JoinColumn(name = "profile_id")
	private Profile profile;

	@Column(name = "fullname")
	private String fullName;

	public UsersByProjectDTO(String firstName, String secondName, String secondSurname,
			String surname, String userName, Profile profile, String fullName) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.secondSurname = secondSurname;
		this.surname = surname;
		this.userName = userName;
		this.profile = profile;
		this.fullName = fullName;
	}

	public UsersByProjectDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	private static final long serialVersionUID = 2419207186540854904L;

}
