package co.edu.usbcali.projectmanager.model.request;

import java.io.Serializable;

import co.edu.usbcali.projectmanager.model.entities.Userapp;

public class SignupRequest implements Serializable {

	private Userapp userapp;

	public Userapp getUserapp() {
		return userapp;
	}

	public void setUserapp(Userapp userapp) {
		this.userapp = userapp;
	}

	private static final long serialVersionUID = -486180400748210308L;

}
