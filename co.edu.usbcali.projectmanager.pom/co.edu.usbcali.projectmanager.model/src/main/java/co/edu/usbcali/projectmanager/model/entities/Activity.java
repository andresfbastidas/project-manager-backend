package co.edu.usbcali.projectmanager.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the activity database table.
 * 
 */
@Entity
@NamedQuery(name="Activity.findAll", query="SELECT a FROM Activity a")
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACTIVITY_ACTIVITYID_GENERATOR", sequenceName="ACTIVITY_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACTIVITY_ACTIVITYID_GENERATOR")
	@Column(name="activity_id")
	private Long activityId;

	@Column(name="activity_name")
	private String activityName;

	@Column(name="assigned_user")
	private String assignedUser;

	@Temporal(TemporalType.DATE)
	@Column(name="date_from")
	private Date dateFrom;

	@Temporal(TemporalType.DATE)
	@Column(name="date_until")
	private Date dateUntil;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;

	//bi-directional many-to-one association to StateActivity
	@ManyToOne
	@JoinColumn(name="state_activity_id")
	private StateActivity stateActivity;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="activity")
	private List<Comment> comments;

	//bi-directional many-to-one association to LinkAttached
	@OneToMany(mappedBy="activity")
	private List<LinkAttached> linkAttacheds;

	public Activity() {
	}

	public Long getActivityId() {
		return this.activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return this.activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getAssignedUser() {
		return this.assignedUser;
	}

	public void setAssignedUser(String assignedUser) {
		this.assignedUser = assignedUser;
	}

	public Date getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateUntil() {
		return this.dateUntil;
	}

	public void setDateUntil(Date dateUntil) {
		this.dateUntil = dateUntil;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public StateActivity getStateActivity() {
		return this.stateActivity;
	}

	public void setStateActivity(StateActivity stateActivity) {
		this.stateActivity = stateActivity;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setActivity(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setActivity(null);

		return comment;
	}

	public List<LinkAttached> getLinkAttacheds() {
		return this.linkAttacheds;
	}

	public void setLinkAttacheds(List<LinkAttached> linkAttacheds) {
		this.linkAttacheds = linkAttacheds;
	}

	public LinkAttached addLinkAttached(LinkAttached linkAttached) {
		getLinkAttacheds().add(linkAttached);
		linkAttached.setActivity(this);

		return linkAttached;
	}

	public LinkAttached removeLinkAttached(LinkAttached linkAttached) {
		getLinkAttacheds().remove(linkAttached);
		linkAttached.setActivity(null);

		return linkAttached;
	}

}