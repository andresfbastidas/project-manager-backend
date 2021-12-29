package co.edu.usbcali.projectmanager.fcd.controllers;

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

import co.edu.usbcali.projectmanager.business.interfaces.IProjectService;
import co.edu.usbcali.projectmanager.model.constant.FcdConstants;
import co.edu.usbcali.projectmanager.model.constant.KeyConstants;
import co.edu.usbcali.projectmanager.model.dto.ProjectUserDirectorNameDTO;
import co.edu.usbcali.projectmanager.model.dto.UsersByProjectDTO;
import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.AssociatedUserProjectRequest;
import co.edu.usbcali.projectmanager.model.request.CreateProjectRequest;
import co.edu.usbcali.projectmanager.model.response.GenericResponse;
import co.edu.usbcali.projectmanager.model.response.ListUsersByProjectResponse;
import co.edu.usbcali.projectmanager.model.response.ProjectListByStateResponse;
import co.edu.usbcali.projectmanager.model.response.ProjectListResponse;

@RestController
@CrossOrigin(origins = "${cross.origin}")
@RequestMapping(path = FcdConstants.PROJECT)
public class ProjectController {

	@Autowired
	private IProjectService projectService;

	@PostMapping(path = FcdConstants.CREATE_PROJECT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> createProject(@Valid @RequestBody CreateProjectRequest createProjectRequest)
			throws ProjectManagementException {

		projectService.createProject(createProjectRequest);

		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage(KeyConstants.SUCCESS_CREATE_PROJECT);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);

	}

	@PostMapping(path = FcdConstants.ASSOCIATED_PROJECT_USER, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> associatedProjectUser(
			@Valid @RequestBody AssociatedUserProjectRequest associatedUserProjectRequest)
			throws ProjectManagementException {

		projectService.associateUser(associatedUserProjectRequest);

		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage(KeyConstants.SUCCESS_ASSOCIATED_PROJECT_USER);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);

	}

	@GetMapping(path = FcdConstants.FINDALL_PROJECTS_BY_STATE)
	@ResponseBody
	public ResponseEntity<?> findAllProjectsByState() throws ProjectManagementException {

		ProjectListByStateResponse<Project> projectListResponse = projectService.findAllProjectByState();
		return new ResponseEntity<>(projectListResponse, HttpStatus.OK);
	}

	@GetMapping(path = FcdConstants.FINDALL_PROJECTS_BY_USER_NAME + "{userName}")
	@ResponseBody
	public ResponseEntity<?> findAllProjectsByUserName(@Valid @PathVariable String userName)
			throws ProjectManagementException {

		ProjectListResponse<ProjectUserDirectorNameDTO> projectListResponse = projectService
				.findAllProjectsByUserName(userName);
		return new ResponseEntity<>(projectListResponse, HttpStatus.OK);
	}

	@GetMapping(path = FcdConstants.FINDALL_USERS_BY_PROJECT + "{projectId}")
	@ResponseBody
	public ResponseEntity<?> listUsersByProject(@Valid @PathVariable Long projectId) throws ProjectManagementException {

		ListUsersByProjectResponse<UsersByProjectDTO> listUsersByProjectResponse = projectService
				.listUsersByProject(projectId);
		return new ResponseEntity<>(listUsersByProjectResponse, HttpStatus.OK);
	}

}
