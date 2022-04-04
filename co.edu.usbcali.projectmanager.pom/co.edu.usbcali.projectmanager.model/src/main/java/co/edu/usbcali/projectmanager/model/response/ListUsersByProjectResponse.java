package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;
import java.util.List;

import co.edu.usbcali.projectmanager.model.dto.UsersByProjectDTO;

public class ListUsersByProjectResponse<T> implements Serializable {

	private List<UsersByProjectDTO> listUsers;
	private int currentPage;
	private Long totalElements;
	private int totalPages;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<UsersByProjectDTO> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<UsersByProjectDTO> listUsers) {
		this.listUsers = listUsers;
	}

	private static final long serialVersionUID = 3470587081880126786L;

}
