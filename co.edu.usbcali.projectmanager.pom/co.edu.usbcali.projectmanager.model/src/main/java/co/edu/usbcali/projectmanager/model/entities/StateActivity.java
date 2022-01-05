package co.edu.usbcali.projectmanager.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the state_activity database table.
 * 
 */
@Entity
@Table(name="state_activity")
@NamedQuery(name="StateActivity.findAll", query="SELECT s FROM StateActivity s")
public class StateActivity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="state_activity_id")
	private Long stateActivityId;

	@Column(name="name_state_activity")
	private String nameStateActivity;

	//bi-directional many-to-one association to Activity
	@OneToMany(mappedBy="stateActivity")
	@JsonIgnore
	private List<Activity> activities;

	public StateActivity() {
	}

	public Long getStateActivityId() {
		return this.stateActivityId;
	}

	public void setStateActivityId(Long stateActivityId) {
		this.stateActivityId = stateActivityId;
	}

	public String getNameStateActivity() {
		return this.nameStateActivity;
	}

	public void setNameStateActivity(String nameStateActivity) {
		this.nameStateActivity = nameStateActivity;
	}

	public List<Activity> getActivities() {
		return this.activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public Activity addActivity(Activity activity) {
		getActivities().add(activity);
		activity.setStateActivity(this);

		return activity;
	}

	public Activity removeActivity(Activity activity) {
		getActivities().remove(activity);
		activity.setStateActivity(null);

		return activity;
	}

}