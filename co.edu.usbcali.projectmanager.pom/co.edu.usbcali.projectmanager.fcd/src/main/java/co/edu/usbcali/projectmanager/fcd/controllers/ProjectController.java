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

import co.edu.usbcali.projectmanager.business.interfaces.IProjectService;
import co.edu.usbcali.projectmanager.model.constant.FcdConstants;
import co.edu.usbcali.projectmanager.model.constant.KeyConstants;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.ProjectRequest;
import co.edu.usbcali.projectmanager.model.response.GenericResponse;

@RestController
@CrossOrigin(origins = "${cross.origin}")
@RequestMapping(path = FcdConstants.PROJECT)
public class ProjectController {

	@Autowired
	private IProjectService projectService;

	@PostMapping(path = FcdConstants.CREATE_PROJECT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> createProject(@Valid @RequestBody ProjectRequest projectRequest)
			throws ProjectManagementException, SQLException  {
		
		projectService.createProject(projectRequest);
		
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage(KeyConstants.SUCCESS_CREATE_PROJECT);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);

	}

}
