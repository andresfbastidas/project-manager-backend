package co.edu.usbcali.projectmanager.fcd.controllers;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.projectmanager.business.interfaces.ICommentService;
import co.edu.usbcali.projectmanager.model.constant.FcdConstants;
import co.edu.usbcali.projectmanager.model.constant.KeyConstants;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.CommentRequest;
import co.edu.usbcali.projectmanager.model.request.UpdateCommentRequest;
import co.edu.usbcali.projectmanager.model.response.GenericResponse;
import co.edu.usbcali.projectmanager.model.response.ListCommentResponse;

@RestController
@CrossOrigin(origins = "${projectmanager.allowedOriginsApps}")
@RequestMapping(path = FcdConstants.COMMENT)
public class CommentController {

	@Autowired
	private ICommentService commentService;

	@PostMapping(path = FcdConstants.NEW_COMMENT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> createActivity(@Valid @RequestBody CommentRequest commentRequest)
			throws ProjectManagementException {

		commentService.newComment(commentRequest);

		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage(KeyConstants.NEW_COMMENT);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);

	}

	@GetMapping(path = FcdConstants.FIND_ALL_COMMENTS_BY_ACTIVITY + "{activityId}")
	@ResponseBody
	public ResponseEntity<Object> findCommentsByActivityId(@Valid @PathVariable Long activityId,
			@RequestParam int numPage, @RequestParam int size) throws ProjectManagementException, SQLException {

		Pageable paging = PageRequest.of(numPage, size);
		ListCommentResponse listCommentResponse = new ListCommentResponse();
		listCommentResponse = commentService.findCommentsByActivityId(paging, activityId);
		return new ResponseEntity<>(listCommentResponse, HttpStatus.OK);

	}

	@PutMapping(path = FcdConstants.UPDATE_COMMENT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateComment(@Valid @RequestBody UpdateCommentRequest updateCommentRequest)
			throws ProjectManagementException {

		commentService.updateComment(updateCommentRequest);
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage(KeyConstants.UPDATE_COMMENT);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);
	}

	@DeleteMapping(path = FcdConstants.DELETE_COMMENT)
	public ResponseEntity<?> deleteActivity(@RequestParam Long commentId) throws ProjectManagementException {

		commentService.deleteComment(commentId);
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage(KeyConstants.DELETE_COMMENT);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);
	}
}
