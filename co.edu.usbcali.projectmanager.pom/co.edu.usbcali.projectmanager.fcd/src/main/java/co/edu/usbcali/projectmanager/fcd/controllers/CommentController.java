package co.edu.usbcali.projectmanager.fcd.controllers;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.projectmanager.business.interfaces.ICommentService;
import co.edu.usbcali.projectmanager.model.constant.FcdConstants;
import co.edu.usbcali.projectmanager.model.constant.KeyConstants;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.CommentRequest;
import co.edu.usbcali.projectmanager.model.response.GenericResponse;

@RestController
@CrossOrigin(origins = "${projectmanager.allowedOriginsApps}")
@RequestMapping(path = FcdConstants.COMMENT)
public class CommentController {

	@Autowired
	private ICommentService commentService;

	@PostMapping(path = FcdConstants.NEW_COMMENT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> createActivity(@Valid @RequestBody CommentRequest commentRequest)
			throws ProjectManagementException, SQLException {

		commentService.newComment(commentRequest);

		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage(KeyConstants.NEW_COMMENT);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);

	}
}
