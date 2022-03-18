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

import co.edu.usbcali.projectmanager.business.interfaces.IActivityService;
import co.edu.usbcali.projectmanager.model.constant.FcdConstants;
import co.edu.usbcali.projectmanager.model.constant.KeyConstants;
import co.edu.usbcali.projectmanager.model.entities.StateActivity;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.ActivityRequest;
import co.edu.usbcali.projectmanager.model.request.UpdateActivityRequest;
import co.edu.usbcali.projectmanager.model.response.GenericListResponse;
import co.edu.usbcali.projectmanager.model.response.GenericResponse;
import co.edu.usbcali.projectmanager.model.response.ListActivitiesResponse;

@RestController
@CrossOrigin(origins = "${projectmanager.allowedOriginsApps}")
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

	@GetMapping(path = FcdConstants.FINDALL_ACTIVITIES_BY_PROJECT + "{projectId}")
	@ResponseBody
	public ResponseEntity<?> findAllActivitiesByProject(@Valid @PathVariable Long projectId, @RequestParam int numPage,
			@RequestParam int size) throws ProjectManagementException {

		Pageable paging = PageRequest.of(numPage, size);
		ListActivitiesResponse listActivitiesResponse = new ListActivitiesResponse();
		listActivitiesResponse = activityService.findActivitiesByProject(paging, projectId);
		return new ResponseEntity<>(listActivitiesResponse, HttpStatus.OK);
	}

	@GetMapping(path = FcdConstants.FINDALL_STATES_ACTIVITIES)
	@ResponseBody
	public ResponseEntity<?> findAllStatesActivities() throws ProjectManagementException {

		GenericListResponse<StateActivity> stateListResponse = activityService.findAllStatesActivities();
		return new ResponseEntity<>(stateListResponse, HttpStatus.OK);
	}

	@PutMapping(path = FcdConstants.UPDATE_ACTIVITY, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateActivity(@Valid @RequestBody UpdateActivityRequest updateActivityRequest)
			throws ProjectManagementException {

		activityService.updateActivity(updateActivityRequest.getActivityId());
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage(KeyConstants.UPDATE_ACTIVITY_STATE);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);
	}

	@DeleteMapping(path = FcdConstants.DELETE_ACTIVITY)
	public ResponseEntity<?> deleteActivity(@RequestParam Long activityId) throws ProjectManagementException {

		activityService.deleteActivity(activityId);
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage(KeyConstants.DELETE_ACTIVITY);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);
	}

}
