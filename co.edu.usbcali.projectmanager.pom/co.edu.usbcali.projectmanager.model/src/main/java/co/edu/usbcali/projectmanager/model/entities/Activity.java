package co.edu.usbcali.projectmanager.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the "Activity" database table.
 * 
 */
@Entity
@Table(name="Activity")
@NamedQuery(name="Activity.findAll", query="SELECT a FROM Activity a")
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACTIVITYID_GENERATOR", sequenceName="ACTIVITY_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACTIVITYID_GENERATOR")
	@Column(name="activity_id")
	private Long activityId;

	@Column(name="activity_name")
	private String activityName;

	@Column(name="activity_state")
	private String activityState;

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

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="id_state")
	private State state;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="activity")
	private List<Comment> comments;

	//bi-directional many-to-one association to Link_Attached
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

	public String getActivityState() {
		return this.activityState;
	}

	public void setActivityState(String activityState) {
		this.activityState = activityState;
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

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
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