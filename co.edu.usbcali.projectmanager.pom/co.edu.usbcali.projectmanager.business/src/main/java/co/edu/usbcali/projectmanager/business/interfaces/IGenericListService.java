package co.edu.usbcali.projectmanager.business.interfaces;

import co.edu.usbcali.projectmanager.model.entities.Delivery;
import co.edu.usbcali.projectmanager.model.entities.ResearchTypology;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.response.GenericListResponse;

public interface IGenericListService {

	public GenericListResponse<Delivery> findAllDeliverysList() throws ProjectManagementException;
	
	public GenericListResponse<ResearchTypology> findAllResearchTypologyList() throws ProjectManagementException;
}
