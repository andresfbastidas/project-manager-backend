package co.edu.usbcali.projectmanager.business.interfaces;

import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.CommentRequest;

public interface ICommentService {

	public void newComment(CommentRequest commentRequest) throws ProjectManagementException;
}
