package co.edu.usbcali.projectmanager.business.interfaces;

import co.edu.usbcali.projectmanager.model.entities.Delivery;
import co.edu.usbcali.projectmanager.model.entities.Profile;
import co.edu.usbcali.projectmanager.model.entities.ResearchTypology;
import co.edu.usbcali.projectmanager.model.entities.State;
import co.edu.usbcali.projectmanager.model.entities.StateProjectRequest;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.response.GenericListResponse;

public interface IGenericListService {

	public GenericListResponse<Delivery> findAllDeliverysList() throws ProjectManagementException;

	public GenericListResponse<ResearchTypology> findAllResearchTypologyList() throws ProjectManagementException;

	public GenericListResponse<State> findAllStatesProjects(Long solini, Long decline, Long finished, Long progress,
			Long avalaible) throws ProjectManagementException;

	public GenericListResponse<Profile> findAllProfiles() throws ProjectManagementException;

	public GenericListResponse<StateProjectRequest> findAllStateProjectRequest() throws ProjectManagementException;
}
