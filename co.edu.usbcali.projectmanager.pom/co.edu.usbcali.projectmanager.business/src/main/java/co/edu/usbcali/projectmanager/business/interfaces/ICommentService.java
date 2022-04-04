package co.edu.usbcali.projectmanager.business.interfaces;

import org.springframework.data.domain.Pageable;

import co.edu.usbcali.projectmanager.model.entities.Comment;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.CommentRequest;
import co.edu.usbcali.projectmanager.model.request.UpdateCommentRequest;
import co.edu.usbcali.projectmanager.model.response.ListCommentResponse;

public interface ICommentService {

	public void newComment(CommentRequest commentRequest) throws ProjectManagementException;

	public Comment findCommentById(Long commentId) throws ProjectManagementException;

	public ListCommentResponse findCommentsByActivityId(Pageable page, Long activityId)
			throws ProjectManagementException;

	public void updateComment(UpdateCommentRequest updateCommentRequest) throws ProjectManagementException;

	public void deleteComment(Long commentId) throws ProjectManagementException;
}
