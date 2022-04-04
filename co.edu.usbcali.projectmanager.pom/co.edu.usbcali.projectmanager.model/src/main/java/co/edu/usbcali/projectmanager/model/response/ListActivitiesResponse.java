package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;
import java.util.List;

import co.edu.usbcali.projectmanager.model.entities.Activity;

public class ListActivitiesResponse implements Serializable {

	List<Activity> listActivities;
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

	public List<Activity> getListActivities() {
		return listActivities;
	}

	public void setListActivities(List<Activity> listActivities) {
		this.listActivities = listActivities;
	}

	private static final long serialVersionUID = 2936480079133667095L;

}
