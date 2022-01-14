package co.edu.usbcali.projectmanager.business.interfaces;

import java.util.List;

import co.edu.usbcali.projectmanager.model.dto.ProjectUserDirectorNameDTO;
import co.edu.usbcali.projectmanager.model.dto.UsersByProjectDTO;
import co.edu.usbcali.projectmanager.model.entities.Delivery;
import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.entities.ProjectDelivery;
import co.edu.usbcali.projectmanager.model.entities.ProjectRequest;
import co.edu.usbcali.projectmanager.model.entities.Userapp;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.request.ApprovalDeclineRequest;
import co.edu.usbcali.projectmanager.model.request.AssociatedUserProjectRequest;
import co.edu.usbcali.projectmanager.model.request.CreateProjectRequest;
import co.edu.usbcali.projectmanager.model.response.ListUsersByProjectResponse;
import co.edu.usbcali.projectmanager.model.response.ProjectListByStateResponse;
import co.edu.usbcali.projectmanager.model.response.ProjectListResponse;

public interface IProjectService {

	public void createProject(CreateProjectRequest createProjectRequest) throws ProjectManagementException;

	public ProjectDelivery saveProjectDelivery(List<Delivery> listDeliveries, Project project)
			throws ProjectManagementException;

	public Project findByProjectId(Long projectId) throws ProjectManagementException;

	public void associateUser(AssociatedUserProjectRequest associatedUserProject) throws ProjectManagementException;

	public void saveProjectUser(Project project, Userapp userapp) throws ProjectManagementException;

	public ProjectListByStateResponse<Project> findAllProjectByState(Long stateId) throws ProjectManagementException;

	public ProjectListResponse<ProjectUserDirectorNameDTO> findAllProjectsByUserName(String userName)
			throws ProjectManagementException;

	public ListUsersByProjectResponse<UsersByProjectDTO> listUsersByProject(Long projectId)
			throws ProjectManagementException;

	public void approvalProject(ApprovalDeclineRequest approvalDeclineRequest) throws ProjectManagementException;

	public void declineProject(ApprovalDeclineRequest approvalDeclineRequest) throws ProjectManagementException;

	public List<ProjectRequest> findProjectRequestByState(Long stateProjectRequestFirst, Long stateProjectRequestSecond,
			Long stateProjectRequestThird, String userName) throws ProjectManagementException;

	public List<ProjectRequest> findProjectRequestByStateUser(Long stateProjectRequestFirst,
			Long stateProjectRequestSecond, Long stateProjectRequestThird, String userName)
			throws ProjectManagementException;
}
