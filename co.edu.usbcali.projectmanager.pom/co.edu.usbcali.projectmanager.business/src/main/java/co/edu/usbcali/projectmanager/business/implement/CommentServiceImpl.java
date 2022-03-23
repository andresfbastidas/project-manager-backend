package co.edu.usbcali.projectmanager.business.implement;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.projectmanager.business.interfaces.IActivityService;
import co.edu.usbcali.projectmanager.business.interfaces.ICommentService;
import co.edu.usbcali.projectmanager.business.utils.ServiceUtils;
import co.edu.usbcali.projectmanager.model.constant.KeyConstants;
import co.edu.usbcali.projectmanager.model.entities.Activity;
import co.edu.usbcali.projectmanager.model.entities.Comment;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.CommentRequest;
import co.edu.usbcali.projectmanager.model.request.UpdateCommentRequest;
import co.edu.usbcali.projectmanager.model.response.ListCommentResponse;
import co.edu.usbcali.projectmanager.repository.CommentRepository;

@Service
public class CommentServiceImpl extends ServiceUtils implements ICommentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommentServiceImpl.class);

	private static final String CLASS_NAME = "CommentServiceImpl";

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private IActivityService activityService;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void newComment(CommentRequest commentRequest) throws ProjectManagementException {
		Activity activity = null;
		Date currentDate = Calendar.getInstance().getTime();
		try {
			activity = activityService.findActivityById(commentRequest.getActivityId());
			Comment comment = this.buildComment(activity, commentRequest.getComment().getCommentDescription(),
					currentDate);
			commentRepository.save(comment);
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}

	}

	private Comment buildComment(Activity activity, String commentDescription, Date currentDate) {
		Comment comment = new Comment();
		comment.setActivity(activity);
		comment.setCommentDescription(commentDescription);
		comment.setCreationDate(currentDate);
		return comment;
	}

	@Override
	public ListCommentResponse findCommentsByActivityId(Pageable page, Long activityId)
			throws ProjectManagementException {
		Page<Comment> listPageComment = null;
		Activity activity = null;
		ListCommentResponse listCommentResponse = new ListCommentResponse();
		try {
			activity = activityService.findActivityById(activityId);
			listPageComment = commentRepository.findCommentsByActivityId(page, activity.getActivityId());

			if (listPageComment.getContent().isEmpty() || listPageComment == null) {
				buildCustomException(KeyConstants.ERROR_COMMENT_LIST_NOT_FOUND, KeyConstants.ERROR_CODE_LIST_COMMENT);
			}

			listCommentResponse.setListComments(listPageComment.getContent());
			listCommentResponse.setCurrentPage(listPageComment.getNumber());
			listCommentResponse.setTotalElements(listPageComment.getTotalElements());
			listCommentResponse.setTotalPages(listPageComment.getTotalPages());

		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
		return listCommentResponse;
	}

	@Override
	public void updateComment(UpdateCommentRequest updateCommentRequest) throws ProjectManagementException {
		Comment comment = null;
		Activity activity = null;
		try {
			comment = this.findCommentById(updateCommentRequest.getComment().getCommentId());
			comment.setCommentDescription(updateCommentRequest.getComment().getCommentDescription());
			activity = activityService.findActivityById(updateCommentRequest.getComment().getActivity().getActivityId());
			comment.setActivity(activity);
			commentRepository.save(comment);
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}

	}

	@Override
	public void deleteComment(Long commentId) throws ProjectManagementException {
		Comment comment = null;
		try {
			comment = this.findCommentById(commentId);
			commentRepository.delete(comment);
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}

	}

	@Override
	public Comment findCommentById(Long commentId) throws ProjectManagementException {
		Comment comment = null;
		try {
			comment = commentRepository.findByCommentId(commentId);

			if (comment == null) {
				buildCustomException(KeyConstants.ERROR_FIND_COMMENT, KeyConstants.ERROR_CODE_COMMENT_NOT_FOUND);
			}
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}

		return comment;
	}

}
