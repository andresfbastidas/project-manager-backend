package co.edu.usbcali.projectmanager.business.interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;

import co.edu.usbcali.projectmanager.model.dto.ProjectUserDirectorNameDTO;
import co.edu.usbcali.projectmanager.model.dto.ProjectsListDTO;
import co.edu.usbcali.projectmanager.model.dto.UsersByProjectDTO;
import co.edu.usbcali.projectmanager.model.entities.Delivery;
import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.entities.ProjectDelivery;
import co.edu.usbcali.projectmanager.model.entities.Userapp;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.ApprovalRequest;
import co.edu.usbcali.projectmanager.model.request.AssociatedUserProjectRequest;
import co.edu.usbcali.projectmanager.model.request.CreateProjectRequest;
import co.edu.usbcali.projectmanager.model.request.DeclineRequest;
import co.edu.usbcali.projectmanager.model.request.UpdateProjectRequest;
import co.edu.usbcali.projectmanager.model.request.UpdateProjectState;
import co.edu.usbcali.projectmanager.model.response.ListProjectRequestsResponse;
import co.edu.usbcali.projectmanager.model.response.ListUsersByProjectResponse;
import co.edu.usbcali.projectmanager.model.response.ProjectListByStateResponse;
import co.edu.usbcali.projectmanager.model.response.ProjectListResponse;
import co.edu.usbcali.projectmanager.model.response.ProjectResponse;

public interface IProjectService {

	public void createProject(CreateProjectRequest createProjectRequest) throws ProjectManagementException;

	public ProjectDelivery saveProjectDelivery(List<Delivery> listDeliveries, Project project)
			throws ProjectManagementException;

	public ProjectResponse findByProjectId(Long projectId) throws ProjectManagementException;

	public void associateUser(AssociatedUserProjectRequest associatedUserProject) throws ProjectManagementException;

	public void saveProjectUser(Project project, Userapp userapp) throws ProjectManagementException;

	public ProjectListByStateResponse<Project> findAllProjectByState(Pageable page, Long stateId)
			throws ProjectManagementException;

	public ProjectsListDTO findProjectDTO(Long projectId) throws ProjectManagementException;

	public ProjectListResponse<ProjectUserDirectorNameDTO> findAllProjectsByUserName(Pageable page, String userName)
			throws ProjectManagementException;

	public ListUsersByProjectResponse<UsersByProjectDTO> listUsersByProject(Pageable page, Long projectId)
			throws ProjectManagementException;

	public void approvalProject(ApprovalRequest approvalRequest) throws ProjectManagementException;

	public void declineProject(DeclineRequest declineRequest) throws ProjectManagementException;

	public ListProjectRequestsResponse findProjectRequestByState(Pageable page, Long stateProjectRequestFirst,
			Long stateProjectRequestSecond, Long stateProjectRequestThird, String userName)
			throws ProjectManagementException;

	public ListProjectRequestsResponse findProjectRequestByStateUser(Pageable page, Long stateProjectRequestFirst,
			Long stateProjectRequestSecond, Long stateProjectRequestThird, String userName)
			throws ProjectManagementException;

	public void updateProjectAndProjectRequest(UpdateProjectRequest updateProjectRequest)
			throws ProjectManagementException;

	public void updateProjectState(UpdateProjectState updateProjectState) throws ProjectManagementException;
}
