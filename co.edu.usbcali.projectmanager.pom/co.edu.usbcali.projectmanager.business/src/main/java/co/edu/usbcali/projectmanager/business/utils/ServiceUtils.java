package co.edu.usbcali.projectmanager.business.utils;

import org.springframework.stereotype.Component;

import co.edu.usbcali.projectmanager.model.exception.ProjectManagementException;
import co.edu.usbcali.projectmanager.model.utils.ComponentUtils;

@Component
public class ServiceUtils extends ComponentUtils {

	protected static final String BUSINESSCODE = "BE001";

	protected static final String BUSINESS_TYPE = "BUSINESS";

	protected static final String LOGGER_ERROR = "ERROR";

	public void buildCustomException(String msgKey, String businessCode) throws ProjectManagementException {
		callCustomException(msgKey, null, businessCode);
	}

	public void callCustomException(String msgKey, Exception e) throws ProjectManagementException {
		throw new ProjectManagementException(BUSINESSCODE, getErrMessage(msgKey), BUSINESS_TYPE, LOGGER_ERROR, e);
	}

	public void callCustomException(String msgKey, Exception e, String businessCode) throws ProjectManagementException {
		throw new ProjectManagementException(businessCode, getErrMessage(msgKey), BUSINESS_TYPE, LOGGER_ERROR, e);
	}

	public void callCustomException(String msgKey, Exception e, String businessCode, String msjConcatenado)
			throws ProjectManagementException {
		throw new ProjectManagementException(businessCode, getErrMessage(msgKey) + " " + msjConcatenado, BUSINESS_TYPE,
				LOGGER_ERROR, e);
	}

}
