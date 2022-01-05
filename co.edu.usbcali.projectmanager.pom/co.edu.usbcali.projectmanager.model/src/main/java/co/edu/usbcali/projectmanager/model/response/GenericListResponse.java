package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;
import java.util.List;

public class GenericListResponse<T> implements Serializable {

	private List<T> genericList;

	public List<T> getGenericList() {
		return genericList;
	}

	public void setGenericList(List<T> genericList) {
		this.genericList = genericList;
	}

	private static final long serialVersionUID = 1500700876009184740L;

}
