package co.edu.usbcali.projectmanager.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import co.edu.usbcali.projectmanager.model.dto.ProjectRequestDTO;
import co.edu.usbcali.projectmanager.model.dto.ProjectUserDirectorNameDTO;
import co.edu.usbcali.projectmanager.model.dto.ProjectsListDTO;
import co.edu.usbcali.projectmanager.model.dto.UsersByProjectDTO;
import co.edu.usbcali.projectmanager.model.entities.Delivery;
import co.edu.usbcali.projectmanager.model.entities.Profile;
import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.entities.ProjectDelivery;
import co.edu.usbcali.projectmanager.model.entities.ProjectRequest;
import co.edu.usbcali.projectmanager.model.entities.ProjectUser;
import co.edu.usbcali.projectmanager.model.entities.ResearchTypology;
import co.edu.usbcali.projectmanager.model.entities.State;
import co.edu.usbcali.projectmanager.model.entities.StateProjectRequest;
import co.edu.usbcali.projectmanager.model.entities.Userapp;
import co.edu.usbcali.projectmanager.model.request.ApprovalRequest;
import co.edu.usbcali.projectmanager.model.request.AssociatedUserProjectRequest;
import co.edu.usbcali.projectmanager.model.request.CreateProjectRequest;
import co.edu.usbcali.projectmanager.model.request.DeclineRequest;
import co.edu.usbcali.projectmanager.model.request.UpdateProjectRequest;
import co.edu.usbcali.projectmanager.model.request.UpdateProjectState;
import co.edu.usbcali.projectmanager.model.response.ProjectListByStateResponse;
import co.edu.usbcali.projectmanager.model.response.ProjectListResponse;
import co.edu.usbcali.projectmanager.model.response.ProjectResponse;

public interface IDataModelUtilTest {

	default CreateProjectRequest buildProjectCreateRequest() {
		CreateProjectRequest createProjectRequest = new CreateProjectRequest();
		createProjectRequest.setProject(buildProject());
		createProjectRequest.setState(buildState());
		ArrayList<Delivery> deliveries = new ArrayList<Delivery>();
		deliveries.add(buildDelivery());
		createProjectRequest.setDeliveries(deliveries);
		createProjectRequest.setUserapp(buildUserApp());
		return createProjectRequest;
	}

	default Project buildProject() {
		Date dateCurrent = Calendar.getInstance().getTime();
		Project project = new Project();
		project.setDateFrom(dateCurrent);
		project.setDateUntil(dateCurrent);
		project.setGeneralObjetive("Objetivo general");
		project.setJustification("Justificacion");
		project.setProjectDirector("andres.bastidas");
		project.setProjectId(12345L);
		project.setProjectMethology("SCRUM");
		project.setProjectResearchTypologyId(1L);
		project.setProjectSummary("RESUMEN");
		project.setProjectTitle("PROJECTO DE PRUEBA");
		project.setResearchProblem("PROBLEMA");
		project.setSpecificObjetive("OBJETIVO ESPECIFICO");
		project.setState(buildState());
		project.setCreateBy("andres.bastidas");
		return project;

	}
	
	default Project buildProjectState() {
		Date dateCurrent = Calendar.getInstance().getTime();
		Project project = new Project();
		project.setDateFrom(dateCurrent);
		project.setDateUntil(dateCurrent);
		project.setGeneralObjetive("Objetivo general");
		project.setJustification("Justificacion");
		project.setProjectDirector("andres.bastidas");
		project.setProjectId(12345L);
		project.setProjectMethology("SCRUM");
		project.setProjectResearchTypologyId(2L);
		project.setProjectSummary("RESUMEN");
		project.setProjectTitle("PROJECTO DE PRUEBA");
		project.setResearchProblem("PROBLEMA");
		project.setSpecificObjetive("OBJETIVO ESPECIFICO");
		project.setState(buildState2());
		project.setCreateBy("andres.bastidas");
		return project;

	}

	default Project buildProjectSolini() {
		Date dateCurrent = Calendar.getInstance().getTime();
		Project project = new Project();
		project.setDateFrom(dateCurrent);
		project.setDateUntil(dateCurrent);
		project.setGeneralObjetive("Objetivo general");
		project.setJustification("Justificacion");
		project.setProjectDirector("andres.bastidas");
		project.setProjectId(12345L);
		project.setProjectMethology("SCRUM");
		project.setProjectResearchTypologyId(1L);
		project.setProjectSummary("RESUMEN");
		project.setProjectTitle("PROJECTO DE PRUEBA");
		project.setResearchProblem("PROBLEMA");
		project.setSpecificObjetive("OBJETIVO ESPECIFICO");
		project.setState(buildStateSolini());
		project.setCreateBy("andres.bastidas");
		return project;

	}

	default Delivery buildDelivery() {
		Delivery delivery = new Delivery();
		delivery.setDeliveryId(1234L);
		delivery.setDeliveryName("Proyecto de grado");
		delivery.setDeliveryType("PD");
		return delivery;
	}

	default List<ProjectDelivery> buildListProjectDelivery() {
		List<ProjectDelivery> listProjectDelivery = new ArrayList<>();
		ProjectDelivery projectDelivery = new ProjectDelivery();
		Project project = buildProject();
		Delivery delivery = buildDelivery();
		projectDelivery.setDelivery(delivery);
		projectDelivery.setProject(project);
		listProjectDelivery.add(projectDelivery);
		return listProjectDelivery;
	}

	default ProjectDelivery buildProjectDelivery() {
		ProjectDelivery projectDelivery = new ProjectDelivery();
		Project project = buildProject();
		Delivery delivery = buildDelivery();
		project = buildProject();
		delivery = buildDelivery();
		projectDelivery.setDelivery(delivery);
		projectDelivery.setProject(project);
		return projectDelivery;
	}

	default ResearchTypology buildResearchTypology() {
		ResearchTypology researchTypology = new ResearchTypology();
		researchTypology.setProjectResearchTypologyId(12345L);
		researchTypology.setTypologyDescription("TIPLOGIA 1");
		return researchTypology;
	}

	default State buildState() {
		State state = new State();
		state.setStateId(5L);
		state.setStateName("DISPONIBLE");
		return state;
	}
	
	default State buildState2() {
		State state = new State();
		state.setStateId(2L);
		state.setStateName("DISPONIBLE");
		return state;
	}

	default State buildStateSolini() {
		State state = new State();
		state.setStateId(1L);
		state.setStateName("SOLICITUD INICIAL");
		return state;
	}

	default Userapp buildUserApp() {
		Userapp userapp = new Userapp();
		userapp.setUserName("andres.bastidas");
		userapp.setEmail("andres.bastidas@hotmail.com");
		userapp.setFirstName("ANDRES");
		userapp.setPassword("123456");
		userapp.setSecondName("FELIPE");
		userapp.setSecondSurname("MAZUERA");
		userapp.setSurname("BASTIDAS");
		userapp.setProfile(buildProfile());
		return userapp;
	}

	default Profile buildProfile() {
		Profile profile = new Profile();
		profile.setProfileId(1L);
		profile.setProfileName("DIRECTOR");
		return profile;
	}

	default AssociatedUserProjectRequest buildAssociatedUserProject() {
		AssociatedUserProjectRequest associatedUserProjectRequest = new AssociatedUserProjectRequest();
		associatedUserProjectRequest.setProjectId(12345L);
		associatedUserProjectRequest.setUserName("andres.bastidas");
		return associatedUserProjectRequest;
	}

	default ProjectResponse builProjectResponse() {
		ProjectResponse projectResponse = new ProjectResponse();
		projectResponse.setProject(buildProject());
		projectResponse.setProjectDeliveries(buildListProjectDelivery());
		return projectResponse;
	}

	default ProjectUser buildProjectUser() {
		ProjectUser projectUser = new ProjectUser();
		projectUser.setProject(buildProject());
		projectUser.setProjectUserId(12345L);
		projectUser.setUserapp(buildUserApp());
		return projectUser;
	}

	default ProjectRequest buildProjectRequest() {
		ProjectRequest projectRequest = new ProjectRequest();
		projectRequest.setProject(buildProject());
		projectRequest.setUserapp(buildUserApp());
		projectRequest.setDetails("Detalle");
		projectRequest.setStateProjectRequest(buildStateProjectRequest());
		projectRequest.setProjectRequestId(1L);
		return projectRequest;
	}
	
	default ProjectRequest buildProjectRequestSuccess() {
		ProjectRequest projectRequest = new ProjectRequest();
		projectRequest.setProject(buildProject());
		projectRequest.setUserapp(buildUserApp());
		projectRequest.setDetails("Detalle");
		projectRequest.setStateProjectRequest(buildStateProjectRequestSuccess());
		projectRequest.setProjectRequestId(3L);
		return projectRequest;
	}

	default StateProjectRequest buildStateProjectRequest() {
		StateProjectRequest stateProjectRequest = new StateProjectRequest();
		stateProjectRequest.setStateProjectRequestId(1L);
		stateProjectRequest.setStateNameProjectRequest("PENDIENTE");
		return stateProjectRequest;
	}
	
	default StateProjectRequest buildStateProjectRequestSuccess() {
		StateProjectRequest stateProjectRequest = new StateProjectRequest();
		stateProjectRequest.setStateProjectRequestId(3L);
		stateProjectRequest.setStateNameProjectRequest("PENDIENTE");
		return stateProjectRequest;
	}

	default List<ProjectsListDTO> buildProjectsAddListDTO() {
		List<ProjectsListDTO> projectsListDTO = new ArrayList<ProjectsListDTO>();
		projectsListDTO.add(buildProjectsListDTO());
		projectsListDTO.add(buildProjectsListDTO());
		projectsListDTO.add(buildProjectsListDTO());
		projectsListDTO.add(buildProjectsListDTO());
		projectsListDTO.add(buildProjectsListDTO());
		projectsListDTO.add(buildProjectsListDTO());
		projectsListDTO.add(buildProjectsListDTO());
		projectsListDTO.add(buildProjectsListDTO());
		projectsListDTO.add(buildProjectsListDTO());
		projectsListDTO.add(buildProjectsListDTO());
		projectsListDTO.add(buildProjectsListDTO());
		return projectsListDTO;
	}

	default Page<ProjectsListDTO> buildProjectsPageListDTO() {
		Page<ProjectsListDTO> pagedResponse = new PageImpl<ProjectsListDTO>(buildProjectsAddListDTO());
		return pagedResponse;
	}

	default ProjectsListDTO buildProjectsListDTO() {
		ProjectsListDTO projectsListDTO = new ProjectsListDTO();
		Date dateCurrent = Calendar.getInstance().getTime();
		projectsListDTO.setDateFrom(dateCurrent);
		projectsListDTO.setDateUntil(dateCurrent);
		projectsListDTO.setGeneralObjetive("Objetivo general");
		projectsListDTO.setJustification("Justificacion");
		projectsListDTO.setProjectDirector("andres.bastidas");
		projectsListDTO.setProjectId(12345L);
		projectsListDTO.setProjectMethology("SCRUM");
		projectsListDTO.setTypologyDescription("PROYECTO DE GRADO");
		projectsListDTO.setProjectSummary("RESUMEN");
		projectsListDTO.setProjectTitle("PROJECTO DE PRUEBA");
		projectsListDTO.setResearchProblem("PROBLEMA");
		projectsListDTO.setSpecificObjetive("OBJETIVO ESPECIFICO");
		projectsListDTO.setStateName("DISPONIBLE");
		projectsListDTO.setCreateBy("andres.bastidas");
		return projectsListDTO;
	}

	default ProjectListByStateResponse<Project> buildProjectListByStateResponse() {
		ProjectListByStateResponse<Project> projectListByStateResponse = new ProjectListByStateResponse<Project>();
		projectListByStateResponse.setProjectList(buildProjectsAddListDTO());
		projectListByStateResponse.setTotalElements(11L);
		projectListByStateResponse.setCurrentPage(0);
		projectListByStateResponse.setTotalPages(10);
		return projectListByStateResponse;
	}

	default ProjectUserDirectorNameDTO buildProjectUserDirectorNameDTO() {
		ProjectUserDirectorNameDTO projectUserDirectorNameDTO = new ProjectUserDirectorNameDTO();
		Date dateCurrent = Calendar.getInstance().getTime();
		State state = new State();
		state.setStateId(1L);
		state.setStateName("DIRECTOR");
		projectUserDirectorNameDTO.setDateFrom(dateCurrent);
		projectUserDirectorNameDTO.setDateUntil(dateCurrent);
		projectUserDirectorNameDTO.setGeneralObjetive("Objetivo general");
		projectUserDirectorNameDTO.setJustification("Justificacion");
		projectUserDirectorNameDTO.setProjectDirector("andres.bastidas");
		projectUserDirectorNameDTO.setProjectId(12345L);
		projectUserDirectorNameDTO.setState(state);
		projectUserDirectorNameDTO.setProjectMethology("SCRUM");
		projectUserDirectorNameDTO.setProjectSummary("RESUMEN");
		projectUserDirectorNameDTO.setProjectTitle("PROJECTO DE PRUEBA");
		projectUserDirectorNameDTO.setSpecificObjetive("OBJETIVO ESPECIFICO");
		projectUserDirectorNameDTO.setCreateBy("andres.bastidas");
		projectUserDirectorNameDTO.setUsers("andres.bastidas, alexandra.castano");
		projectUserDirectorNameDTO.setProjectDirector("andres.bastidas");
		projectUserDirectorNameDTO.setDirectorName("andres.bastidas");
		projectUserDirectorNameDTO.setCreateByNames("andres.bastidas");
		projectUserDirectorNameDTO.setProjectResearchTypologyId(1L);
		return projectUserDirectorNameDTO;
	}

	default ProjectListResponse<ProjectUserDirectorNameDTO> buildProjectUserDirectorNameDTOResponse() {

		ProjectListResponse<ProjectUserDirectorNameDTO> projectListResponse = new ProjectListResponse<ProjectUserDirectorNameDTO>();
		projectListResponse.setProjectList(buildProjectsAddListProjectDirectorNameDTO());
		projectListResponse.setTotalElements(20L);
		projectListResponse.setCurrentPage(0);
		projectListResponse.setTotalPages(10);
		return projectListResponse;
	}

	default List<ProjectUserDirectorNameDTO> buildProjectsAddListProjectDirectorNameDTO() {
		List<ProjectUserDirectorNameDTO> listProjectUserDirectorNameDTOs = new ArrayList<ProjectUserDirectorNameDTO>();
		listProjectUserDirectorNameDTOs.add(buildProjectUserDirectorNameDTO());
		listProjectUserDirectorNameDTOs.add(buildProjectUserDirectorNameDTO());
		listProjectUserDirectorNameDTOs.add(buildProjectUserDirectorNameDTO());
		listProjectUserDirectorNameDTOs.add(buildProjectUserDirectorNameDTO());
		listProjectUserDirectorNameDTOs.add(buildProjectUserDirectorNameDTO());
		listProjectUserDirectorNameDTOs.add(buildProjectUserDirectorNameDTO());
		listProjectUserDirectorNameDTOs.add(buildProjectUserDirectorNameDTO());
		listProjectUserDirectorNameDTOs.add(buildProjectUserDirectorNameDTO());
		listProjectUserDirectorNameDTOs.add(buildProjectUserDirectorNameDTO());
		listProjectUserDirectorNameDTOs.add(buildProjectUserDirectorNameDTO());
		listProjectUserDirectorNameDTOs.add(buildProjectUserDirectorNameDTO());
		listProjectUserDirectorNameDTOs.add(buildProjectUserDirectorNameDTO());
		listProjectUserDirectorNameDTOs.add(buildProjectUserDirectorNameDTO());
		listProjectUserDirectorNameDTOs.add(buildProjectUserDirectorNameDTO());
		listProjectUserDirectorNameDTOs.add(buildProjectUserDirectorNameDTO());
		listProjectUserDirectorNameDTOs.add(buildProjectUserDirectorNameDTO());
		listProjectUserDirectorNameDTOs.add(buildProjectUserDirectorNameDTO());
		listProjectUserDirectorNameDTOs.add(buildProjectUserDirectorNameDTO());
		return listProjectUserDirectorNameDTOs;
	}

	default Page<ProjectUserDirectorNameDTO> buildProjectUserDirectorNameDTOPage() {
		Page<ProjectUserDirectorNameDTO> pagedResponse = new PageImpl<ProjectUserDirectorNameDTO>(
				buildProjectsAddListProjectDirectorNameDTO());
		return pagedResponse;
	}

	default UsersByProjectDTO buildUserByProjectDTO() {
		UsersByProjectDTO usersByProjectDTO = new UsersByProjectDTO();
		usersByProjectDTO.setFirstName("ANDRES");
		usersByProjectDTO.setFullName("ANDRES BASTIDAS");
		Profile profile = new Profile();
		profile.setProfileId(1L);
		profile.setProfileName("DIRECTOR");
		usersByProjectDTO.setProfile(profile);
		usersByProjectDTO.setSecondName("FELIPE");
		usersByProjectDTO.setSecondSurname("MAZUERA");
		usersByProjectDTO.setSurname("BASTIDAS");
		usersByProjectDTO.setUserName("andres.bastidas");
		return usersByProjectDTO;
	}

	default List<UsersByProjectDTO> buildUserByProjectDTOList() {
		List<UsersByProjectDTO> usersByProjectDTOs = new ArrayList<UsersByProjectDTO>();
		usersByProjectDTOs.add(buildUserByProjectDTO());
		usersByProjectDTOs.add(buildUserByProjectDTO());
		usersByProjectDTOs.add(buildUserByProjectDTO());
		usersByProjectDTOs.add(buildUserByProjectDTO());
		usersByProjectDTOs.add(buildUserByProjectDTO());
		usersByProjectDTOs.add(buildUserByProjectDTO());
		usersByProjectDTOs.add(buildUserByProjectDTO());
		usersByProjectDTOs.add(buildUserByProjectDTO());
		usersByProjectDTOs.add(buildUserByProjectDTO());
		usersByProjectDTOs.add(buildUserByProjectDTO());
		return usersByProjectDTOs;
	}

	default Page<UsersByProjectDTO> buildUserByProjectDTOPage() {
		Page<UsersByProjectDTO> pagedResponse = new PageImpl<UsersByProjectDTO>(buildUserByProjectDTOList());
		return pagedResponse;
	}

	default ProjectRequestDTO buildProjectRequestDTO() {
		ProjectRequestDTO projectRequestDTO = new ProjectRequestDTO();
		projectRequestDTO.setDetails("DETALLE");
		projectRequestDTO.setProjectDirector("andres.bastidas");
		projectRequestDTO.setProjectId(12345L);
		projectRequestDTO.setProjectRequestId(12345L);
		projectRequestDTO.setStateNameProjectRequest("APROBADO");
		projectRequestDTO.setStateProjectRequestId(1L);
		projectRequestDTO.setUserName("andres.bastidas");
		return projectRequestDTO;
	}

	default List<ProjectRequestDTO> buildProjectRequestDTOList() {
		List<ProjectRequestDTO> lisProjectRequestDTOs = new ArrayList<ProjectRequestDTO>();
		lisProjectRequestDTOs.add(buildProjectRequestDTO());
		lisProjectRequestDTOs.add(buildProjectRequestDTO());
		lisProjectRequestDTOs.add(buildProjectRequestDTO());
		lisProjectRequestDTOs.add(buildProjectRequestDTO());
		lisProjectRequestDTOs.add(buildProjectRequestDTO());
		lisProjectRequestDTOs.add(buildProjectRequestDTO());
		lisProjectRequestDTOs.add(buildProjectRequestDTO());
		lisProjectRequestDTOs.add(buildProjectRequestDTO());
		lisProjectRequestDTOs.add(buildProjectRequestDTO());
		lisProjectRequestDTOs.add(buildProjectRequestDTO());
		return lisProjectRequestDTOs;
	}

	default Page<ProjectRequestDTO> buildProjectRequestDTOPage() {
		Page<ProjectRequestDTO> pagedResponse = new PageImpl<ProjectRequestDTO>(buildProjectRequestDTOList());
		return pagedResponse;
	}

	default List<ProjectRequest> buildListProjectRequest() {
		List<ProjectRequest> projectRequestList = new ArrayList<ProjectRequest>();
		projectRequestList.add(buildProjectRequest());
		projectRequestList.add(buildProjectRequest());
		projectRequestList.add(buildProjectRequest());
		return projectRequestList;
	}

	default ApprovalRequest buildApprovalRequest() {
		ApprovalRequest approvalRequest = new ApprovalRequest();
		approvalRequest.setListProjectRequests(buildListProjectRequest());
		approvalRequest.setProjectDirector("andres.bastidas");
		return approvalRequest;
	}

	default DeclineRequest buildDeclineRequest() {
		DeclineRequest declineRequest = new DeclineRequest();
		declineRequest.setDetails("NO APROBADO");
		declineRequest.setListProjectRequests(buildListProjectRequest());
		return declineRequest;
	}

	default UpdateProjectRequest buildUpdateProjectRequest() {
		UpdateProjectRequest updateProjectRequest = new UpdateProjectRequest();
		ArrayList<Delivery> deliveries = new ArrayList<Delivery>();
		deliveries.add(buildDelivery());
		deliveries.add(buildDelivery());
		updateProjectRequest.setDeliveries(deliveries);
		updateProjectRequest.setProject(buildProjectState());
		updateProjectRequest.setProjectId(12345L);
		updateProjectRequest.setProjectRequestId(12345L);
		updateProjectRequest.setState(buildState());
		updateProjectRequest.setUserapp(buildUserApp());
		return updateProjectRequest;
	}
	
	default UpdateProjectState buildUpdateProjectState() {
		UpdateProjectState updateProjectState = new UpdateProjectState();
		updateProjectState.setProjectId(12345L);
		return updateProjectState;
	}

}
