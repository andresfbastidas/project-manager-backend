package co.edu.usbcali.projectmanager.fcd.controllers;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.projectmanager.business.interfaces.IActivityService;
import co.edu.usbcali.projectmanager.model.constant.FcdConstants;
import co.edu.usbcali.projectmanager.model.constant.KeyConstants;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.ActivityRequest;
import co.edu.usbcali.projectmanager.model.response.GenericResponse;
import co.edu.usbcali.projectmanager.model.response.ListActivitiesResponse;

@RestController
@CrossOrigin(origins = "${cross.origin}")
@RequestMapping(path = FcdConstants.ACTIVITY)
public class ActivityController {

	@Autowired
	private IActivityService activityService;

	@PostMapping(path = FcdConstants.CREATE_ACTIVITY, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> createActivity(@Valid @RequestBody ActivityRequest activityRequest)
			throws ProjectManagementException, SQLException {

		activityService.createActivity(activityRequest);

		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage(KeyConstants.SUCCESS_CREATE_ACTIVITY);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);

	}

	@GetMapping(path = FcdConstants.FINDALL_ACTIVITIES_BY_PROJECT+"{projectId}")
	@ResponseBody
	public ResponseEntity<?> findAllActivitiesByProject(@Valid @PathVariable Long projectId)
			throws ProjectManagementException {

 		ListActivitiesResponse listActivitiesResponse = new ListActivitiesResponse();
		listActivitiesResponse = activityService.findActivitiesByProject(projectId);
		return new ResponseEntity<>(listActivitiesResponse, HttpStatus.OK);
	}

}
