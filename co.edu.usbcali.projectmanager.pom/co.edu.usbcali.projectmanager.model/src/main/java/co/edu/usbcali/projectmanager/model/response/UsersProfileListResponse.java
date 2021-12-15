package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;
import java.util.List;

import co.edu.usbcali.projectmanager.model.entities.Userapp;

public class UsersProfileListResponse implements Serializable {
	
	private List<Userapp> userappsList;

	public List<Userapp> getUserappsList() {
		return userappsList;
	}

	public void setUserappsList(List<Userapp> userappsList) {
		this.userappsList = userappsList;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1500700876009184740L;

}
