package co.edu.usbcali.projectmanager.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the comment database table.
 * 
 */
@Entity
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMMENT_COMMENTID_GENERATOR", sequenceName="COMMENT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMMENT_COMMENTID_GENERATOR")
	@Column(name="comment_id")
	private Long commentId;

	@Column(name="comment_description")
	private String commentDescription;

	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;

	//bi-directional many-to-one association to Activity
	@ManyToOne
	@JoinColumn(name="activity_id")
	private Activity activity;

	public Comment() {
	}

	public Long getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getCommentDescription() {
		return this.commentDescription;
	}

	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

}