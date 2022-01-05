package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;
import java.util.List;

import co.edu.usbcali.projectmanager.model.dto.UsersByProjectDTO;

public class ListUsersByProjectResponse<T> implements Serializable {

	private List<UsersByProjectDTO> listUsers;

	public List<UsersByProjectDTO> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<UsersByProjectDTO> listUsers) {
		this.listUsers = listUsers;
	}

	private static final long serialVersionUID = 3470587081880126786L;

}
