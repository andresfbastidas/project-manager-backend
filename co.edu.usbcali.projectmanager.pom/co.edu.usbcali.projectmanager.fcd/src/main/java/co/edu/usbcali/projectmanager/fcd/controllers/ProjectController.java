package co.edu.usbcali.projectmanager.fcd.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.projectmanager.business.interfaces.IProjectService;
import co.edu.usbcali.projectmanager.model.constant.FcdConstants;
import co.edu.usbcali.projectmanager.model.constant.KeyConstants;
import co.edu.usbcali.projectmanager.model.dto.ProjectUserDirectorNameDTO;
import co.edu.usbcali.projectmanager.model.dto.UsersByProjectDTO;
import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.ApprovalRequest;
import co.edu.usbcali.projectmanager.model.request.AssociatedUserProjectRequest;
import co.edu.usbcali.projectmanager.model.request.CreateProjectRequest;
import co.edu.usbcali.projectmanager.model.request.DeclineRequest;
import co.edu.usbcali.projectmanager.model.request.UpdateProjectRequest;
import co.edu.usbcali.projectmanager.model.request.UpdateProjectState;
import co.edu.usbcali.projectmanager.model.response.GenericResponse;
import co.edu.usbcali.projectmanager.model.response.ListProjectRequestsResponse;
import co.edu.usbcali.projectmanager.model.response.ListUsersByProjectResponse;
import co.edu.usbcali.projectmanager.model.response.ProjectListByStateResponse;
import co.edu.usbcali.projectmanager.model.response.ProjectListResponse;
import co.edu.usbcali.projectmanager.model.response.ProjectResponse;
import co.edu.usbcali.projectmanager.model.utils.FcdUtil;

@RestController
@CrossOrigin(origins = "${projectmanager.allowedOriginsApps}")
@RequestMapping(path = FcdConstants.PROJECT)
public class ProjectController extends FcdUtil {

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

	@GetMapping(path = FcdConstants.FINDALL_PROJECTS_BY_STATE + "{stateId}")
	@ResponseBody
	public ResponseEntity<?> findAllProjectsByState(@PathVariable Long stateId, @RequestParam int numPage,
			@RequestParam int size) throws ProjectManagementException {

		Pageable paging = PageRequest.of(numPage, size);
		ProjectListByStateResponse<Project> projectListResponse = projectService.findAllProjectByState(paging, stateId);
		return new ResponseEntity<>(projectListResponse, HttpStatus.OK);
	}

	@GetMapping(path = FcdConstants.FINDALL_PROJECTS_BY_USER_NAME + "{userName}")
	@ResponseBody
	public ResponseEntity<?> findAllProjectsByUserName(@Valid @PathVariable String userName, @RequestParam int numPage,
			@RequestParam int size) throws ProjectManagementException {

		Pageable paging = PageRequest.of(numPage, size);
		ProjectListResponse<ProjectUserDirectorNameDTO> projectListResponse = projectService
				.findAllProjectsByUserName(paging, userName);
		return new ResponseEntity<>(projectListResponse, HttpStatus.OK);
	}

	@GetMapping(path = FcdConstants.FINDALL_USERS_BY_PROJECT + "{projectId}")
	@ResponseBody
	public ResponseEntity<?> listUsersByProject(@Valid @PathVariable Long projectId,
			@RequestParam(defaultValue = "0") int numPage, @RequestParam(defaultValue = "10") int size)
			throws ProjectManagementException {

		Pageable paging = PageRequest.of(numPage, size);
		ListUsersByProjectResponse<UsersByProjectDTO> listUsersByProjectResponse = projectService
				.listUsersByProject(paging, projectId);
		return new ResponseEntity<>(listUsersByProjectResponse, HttpStatus.OK);
	}

	@PutMapping(path = FcdConstants.APPROVAL_PROJECTS, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> approvalProjects(@Valid @RequestBody ApprovalRequest approvalDeclineRequest)
			throws ProjectManagementException {

		projectService.approvalProject(approvalDeclineRequest);
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage(KeyConstants.SUCCESS_APPROVAL);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);
	}

	@PutMapping(path = FcdConstants.DECLINE_PROJECTS, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> declineProjects(@Valid @RequestBody DeclineRequest declineRequest)
			throws ProjectManagementException {

		projectService.declineProject(declineRequest);
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage(KeyConstants.DECLINE_PROJECTS);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);
	}

	@GetMapping(path = FcdConstants.FINDALL_PROJECT_REQUEST_BY_STATE + "{stateFirst}" + "+" + "{stateSecond}" + "+"
			+ "{stateThird}/" + "{userName}")
	@ResponseBody
	public ResponseEntity<?> findProjectRequestByState(@Valid @PathVariable Long stateFirst,
			@PathVariable Long stateSecond, @PathVariable Long stateThird, @PathVariable String userName,
			@RequestParam(defaultValue = "0") int numPage, @RequestParam(defaultValue = "10") int size)
			throws ProjectManagementException {
		Pageable paging = PageRequest.of(numPage, size);
		ListProjectRequestsResponse listProjectRequestsResponse = new ListProjectRequestsResponse();
		listProjectRequestsResponse = projectService.findProjectRequestByState(paging, stateFirst, stateSecond,
				stateThird, userName);
		return new ResponseEntity<>(listProjectRequestsResponse, HttpStatus.OK);
	}

	@GetMapping(path = FcdConstants.FINDALL_PROJECT_REQUEST_BY_STATE_USER + "{stateFirst}" + "+" + "{stateSecond}" + "+"
			+ "{stateThird}/" + "{userName}")
	@ResponseBody
	public ResponseEntity<?> findProjectRequestByStateUser(@Valid @PathVariable Long stateFirst,
			@PathVariable Long stateSecond, @PathVariable Long stateThird, @PathVariable String userName,
			@RequestParam int numPage, @RequestParam int size) throws ProjectManagementException {
		Pageable paging = PageRequest.of(numPage, size);
		ListProjectRequestsResponse listProjectRequestsResponse = new ListProjectRequestsResponse();
		listProjectRequestsResponse = projectService.findProjectRequestByStateUser(paging, stateFirst, stateSecond,
				stateThird, userName);
		return new ResponseEntity<>(listProjectRequestsResponse, HttpStatus.OK);
	}

	@PutMapping(path = FcdConstants.UPDATE_PROJECT_PROJECT_REQUEST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateProjectAndProjectRequest(
			@Valid @RequestBody UpdateProjectRequest updateProjectRequest) throws ProjectManagementException {

		projectService.updateProjectAndProjectRequest(updateProjectRequest);
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage(KeyConstants.UPDATE_PROJECT_AND_PROJECT_REQUEST);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);
	}

	@GetMapping(path = FcdConstants.FIND_PROJECT_BY_ID + "{projectId}")
	@ResponseBody
	public ResponseEntity<?> findProjectById(@Valid @PathVariable Long projectId) throws ProjectManagementException {
		ProjectResponse projectResponse = new ProjectResponse();
		projectResponse = projectService.findByProjectId(projectId);
		return new ResponseEntity<>(projectResponse, HttpStatus.OK);
	}

	@PutMapping(path = FcdConstants.UPDATE_PROJECT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateProjectState(@Valid @RequestBody UpdateProjectState updateProjectState)
			throws ProjectManagementException {

		projectService.updateProjectState(updateProjectState);
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage(KeyConstants.UPDATE_PROJECT_STATE);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);
	}

}
