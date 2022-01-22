package co.edu.usbcali.projectmanager.business.implement;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.projectmanager.business.interfaces.IGenericListService;
import co.edu.usbcali.projectmanager.business.utils.ServiceUtils;
import co.edu.usbcali.projectmanager.model.constant.KeyConstants;
import co.edu.usbcali.projectmanager.model.entities.Delivery;
import co.edu.usbcali.projectmanager.model.entities.Profile;
import co.edu.usbcali.projectmanager.model.entities.ResearchTypology;
import co.edu.usbcali.projectmanager.model.entities.State;
import co.edu.usbcali.projectmanager.model.entities.StateProjectRequest;
import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.response.GenericListResponse;
import co.edu.usbcali.projectmanager.repository.DeliveryRepository;
import co.edu.usbcali.projectmanager.repository.ProfileRepository;
import co.edu.usbcali.projectmanager.repository.ResearchTyplogyRepository;
import co.edu.usbcali.projectmanager.repository.StateProjectRequestRepository;
import co.edu.usbcali.projectmanager.repository.StateRepository;

@Service
public class GenericListImpl extends ServiceUtils implements IGenericListService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GenericListImpl.class);

	private static final String CLASS_NAME = "GenericListImpl";

	@Autowired
	private DeliveryRepository deliveryRepository;

	@Autowired
	private ResearchTyplogyRepository researchTyplogyRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private StateProjectRequestRepository stateProjectRequestRepository;

	@Override
	public GenericListResponse<Delivery> findAllDeliverysList() throws ProjectManagementException {
		GenericListResponse<Delivery> genericListResponse = null;
		List<Delivery> deliveries = null;
		try {
			genericListResponse = new GenericListResponse<Delivery>();
			deliveries = deliveryRepository.findAllDeliveriesList();
			if (deliveries.isEmpty() || deliveries == null) {
				buildCustomException(KeyConstants.GENERIC_LIST_EMPTY, KeyConstants.ERROR_CODE_GENERIC_LIST_EMPTY);
			}
			genericListResponse.setGenericList(deliveries);
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
		return genericListResponse;
	}

	@Override
	public GenericListResponse<ResearchTypology> findAllResearchTypologyList() throws ProjectManagementException {
		GenericListResponse<ResearchTypology> genericListResponse = null;
		List<ResearchTypology> researchTypologies = null;
		try {
			genericListResponse = new GenericListResponse<ResearchTypology>();
			researchTypologies = researchTyplogyRepository.findAllResearchTypologiesList();
			if (researchTypologies.isEmpty() || researchTypologies == null) {
				buildCustomException(KeyConstants.GENERIC_LIST_EMPTY, KeyConstants.ERROR_CODE_GENERIC_LIST_EMPTY);
			}
			genericListResponse.setGenericList(researchTypologies);
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
		return genericListResponse;
	}

	@Override
	public GenericListResponse<State> findAllStatesProjects(Long solini, Long decline, Long finished, Long progress,
			Long avalaible) throws ProjectManagementException {
		GenericListResponse<State> genericListResponse = null;
		List<State> states = null;
		try {
			genericListResponse = new GenericListResponse<State>();
			states = stateRepository.findAllStatesProjects(solini, decline, finished, progress, avalaible);
			if (states.isEmpty() || states == null) {
				buildCustomException(KeyConstants.GENERIC_LIST_EMPTY, KeyConstants.ERROR_CODE_GENERIC_LIST_EMPTY);
			}
			genericListResponse.setGenericList(states);
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
		return genericListResponse;
	}

	@Override
	public GenericListResponse<Profile> findAllProfiles() throws ProjectManagementException {
		GenericListResponse<Profile> genericListResponse = null;
		List<Profile> profiles = null;
		try {
			genericListResponse = new GenericListResponse<Profile>();
			profiles = profileRepository.findAllProfiles();
			if (profiles.isEmpty() || profiles == null) {
				buildCustomException(KeyConstants.GENERIC_LIST_EMPTY, KeyConstants.ERROR_CODE_GENERIC_LIST_EMPTY);
			}
			genericListResponse.setGenericList(profiles);
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
		return genericListResponse;
	}

	@Override
	public GenericListResponse<StateProjectRequest> findAllStateProjectRequest() throws ProjectManagementException {
		GenericListResponse<StateProjectRequest> genericListResponse = null;
		List<StateProjectRequest> listStateProjectRequests = null;
		try {
			genericListResponse = new GenericListResponse<StateProjectRequest>();
			listStateProjectRequests = stateProjectRequestRepository.findAll();
			if (listStateProjectRequests.isEmpty() || listStateProjectRequests == null) {
				buildCustomException(KeyConstants.GENERIC_LIST_EMPTY, KeyConstants.ERROR_CODE_GENERIC_LIST_EMPTY);
			}
			genericListResponse.setGenericList(listStateProjectRequests);
		} catch (ProjectManagementException e) {
			throw e;
		} catch (Exception e) {
			LOGGER.error(KeyConstants.UNEXPECTED_ERROR, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
		return genericListResponse;
	}
}
