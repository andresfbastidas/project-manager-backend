package co.edu.usbcali.projectmanager.model.utils;

import org.springframework.stereotype.Component;

@Component
public class ComponentUtils {
	
	public String getErrMessage(String messageKey) {
		String msg =  messageKey;
		msg = String.format(messageKey);			
		return msg;
	}

}
