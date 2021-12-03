package co.edu.usbcali.projectmanager.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Profile" database table.
 * 
 */
@Entity
@Table(name="Profile")
@NamedQuery(name="Profile.findAll", query="SELECT p FROM Profile p")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROFILEID_GENERATOR", sequenceName="PROFILE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROFILEID_GENERATOR")
	@Column(name="profile_id")
	private Long profileId;

	@Column(name="profile_name")
	private String profileName;

	//bi-directional many-to-one association to UserApp
	@OneToMany(mappedBy="profile")
	private List<UserApp> userApps;

	public Profile() {
	}

	public Long getProfileId() {
		return this.profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public String getProfileName() {
		return this.profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public List<UserApp> getUserApps() {
		return this.userApps;
	}

	public void setUserApps(List<UserApp> userApps) {
		this.userApps = userApps;
	}

	public UserApp addUserApp(UserApp userApp) {
		getUserApps().add(userApp);
		userApp.setProfile(this);

		return userApp;
	}

	public UserApp removeUserApp(UserApp userApp) {
		getUserApps().remove(userApp);
		userApp.setProfile(null);

		return userApp;
	}

}