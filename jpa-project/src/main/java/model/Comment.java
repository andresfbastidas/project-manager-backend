package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comment database table.
 * 
 */
@Entity
@Table(name="Comment")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMMENT_COMMENTID_GENERATOR", sequenceName="COMMENT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMMENT_COMMENTID_GENERATOR")
	@Column(name="comment_id")
	private Long commentId;

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

	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

}