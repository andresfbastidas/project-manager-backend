package co.edu.usbcali.projectmanager.business.implement;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import co.edu.usbcali.projectmanager.repository.CommentRepository;

@Service
public class CommentServiceImpl extends ServiceUtils implements ICommentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ActivityServiceImpl.class);

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
			activity = activityService.findActivityById(commentRequest.getComment().getActivity().getActivityId());
			Comment comment = this.buildActivity(activity, commentRequest.getComment().getCommentDescription(),
					currentDate);
			commentRepository.save(comment);
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}

	}

	private Comment buildActivity(Activity activity, String commentDescription, Date currentDate) {
		Comment comment = new Comment();
		comment.setActivity(activity);
		comment.setCommentDescription(commentDescription);
		comment.setCreationDate(currentDate);
		return comment;
	}

}
