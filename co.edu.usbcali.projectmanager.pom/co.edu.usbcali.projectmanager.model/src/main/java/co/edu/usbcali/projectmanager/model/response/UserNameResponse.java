package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;

import co.edu.usbcali.projectmanager.model.entities.Userapp;

public class UserNameResponse implements Serializable {

	private Userapp userapp;

	public Userapp getUserapp() {
		return userapp;
	}

	public void setUserapp(Userapp userapp) {
		this.userapp = userapp;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5054232403837315518L;

}
