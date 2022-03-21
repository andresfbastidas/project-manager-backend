package co.edu.usbcali.projectmanager.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import co.edu.usbcali.projectmanager.model.entities.Delivery;
import co.edu.usbcali.projectmanager.model.entities.Profile;
import co.edu.usbcali.projectmanager.model.entities.Project;
import co.edu.usbcali.projectmanager.model.entities.ProjectDelivery;
import co.edu.usbcali.projectmanager.model.entities.ProjectUser;
import co.edu.usbcali.projectmanager.model.entities.ResearchTypology;
import co.edu.usbcali.projectmanager.model.entities.State;
import co.edu.usbcali.projectmanager.model.entities.Userapp;
import co.edu.usbcali.projectmanager.model.request.AssociatedUserProjectRequest;
import co.edu.usbcali.projectmanager.model.request.CreateProjectRequest;
import co.edu.usbcali.projectmanager.model.response.ProjectResponse;

public interface IDataModelUtilTest {

	default CreateProjectRequest buildProjectRequets() {
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

}
