package co.edu.usbcali.projectmanager.model.request;

import java.io.Serializable;

import co.edu.usbcali.projectmanager.model.entities.Comment;

public class UpdateCommentRequest implements Serializable {

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
	private static final long serialVersionUID = -2114953156400116500L;

}
