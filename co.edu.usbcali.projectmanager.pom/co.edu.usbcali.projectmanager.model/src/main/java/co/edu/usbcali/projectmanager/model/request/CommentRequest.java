package co.edu.usbcali.projectmanager.model.request;

import java.io.Serializable;

import co.edu.usbcali.projectmanager.model.entities.Comment;

public class CommentRequest implements Serializable {

	private Comment comment;

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -723058093883723355L;

}
