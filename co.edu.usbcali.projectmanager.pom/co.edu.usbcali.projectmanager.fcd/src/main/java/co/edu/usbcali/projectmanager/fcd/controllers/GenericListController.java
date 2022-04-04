package co.edu.usbcali.projectmanager.fcd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.projectmanager.business.interfaces.IGenericListService;
import co.edu.usbcali.projectmanager.model.constant.FcdConstants;
import co.edu.usbcali.projectmanager.model.entities.Delivery;
import co.edu.usbcali.projectmanager.model.entities.Profile;
import co.edu.usbcali.projectmanager.model.entities.ResearchTypology;
import co.edu.usbcali.projectmanager.model.entities.State;
import co.edu.usbcali.projectmanager.model.entities.StateProjectRequest;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.response.GenericListResponse;

@RestController
@CrossOrigin(origins = "${projectmanager.allowedOriginsApps}")
@RequestMapping(path = FcdConstants.GENERIC_LIST)
public class GenericListController {

	@Autowired
	private IGenericListService genericListService;

	@GetMapping(path = FcdConstants.FINDALL_DELIVERYS)
	@ResponseBody
	public ResponseEntity<?> findAllDeliverys() throws ProjectManagementException {

		GenericListResponse<Delivery> usersProfileListResponse = genericListService.findAllDeliverysList();
		return new ResponseEntity<>(usersProfileListResponse, HttpStatus.OK);
	}

	@GetMapping(path = FcdConstants.FINDALL_RESEARCH_TYPOLOGYS)
	@ResponseBody
	public ResponseEntity<?> findAllResearchTypologys() throws ProjectManagementException {

		GenericListResponse<ResearchTypology> usersProfileListResponse = genericListService
				.findAllResearchTypologyList();
		return new ResponseEntity<>(usersProfileListResponse, HttpStatus.OK);
	}

	@GetMapping(path = FcdConstants.FIND_ALL_STATES_PROJECTS + "{solini}" + "+"  + "{decline}"  + "+" + "{finished}"  + "+" + "{progress}"  + "+" + "{avalaible}")
	@ResponseBody
	public ResponseEntity<?> findAllStates(@PathVariable Long solini, @PathVariable Long decline,
			@PathVariable Long finished, @PathVariable Long progress, @PathVariable Long avalaible)
			throws ProjectManagementException {

		GenericListResponse<State> usersProfileListResponse = genericListService.findAllStatesProjects(solini, decline,
				finished, progress, avalaible);
		return new ResponseEntity<>(usersProfileListResponse, HttpStatus.OK);
	}

	@GetMapping(path = FcdConstants.FINDALL_PROFILES)
	@ResponseBody
	public ResponseEntity<?> findAllProfiles() throws ProjectManagementException {

		GenericListResponse<Profile> usersProfileListResponse = genericListService.findAllProfiles();
		return new ResponseEntity<>(usersProfileListResponse, HttpStatus.OK);
	}

	@GetMapping(path = FcdConstants.FINDALL_STATE_PROJECT_REQUEST)
	@ResponseBody
	public ResponseEntity<?> findAllStateProjectRequest() throws ProjectManagementException {

		GenericListResponse<StateProjectRequest> usersProfileListResponse = genericListService
				.findAllStateProjectRequest();
		return new ResponseEntity<>(usersProfileListResponse, HttpStatus.OK);
	}
}
