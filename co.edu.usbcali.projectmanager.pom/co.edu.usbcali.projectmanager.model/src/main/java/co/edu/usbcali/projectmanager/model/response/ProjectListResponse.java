package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;
import java.util.List;

import co.edu.usbcali.projectmanager.model.dto.ProjectUserDirectorNameDTO;

public class ProjectListResponse<T> implements Serializable {

	private List<ProjectUserDirectorNameDTO> projectList;
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

	public List<ProjectUserDirectorNameDTO> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<ProjectUserDirectorNameDTO> projectList) {
		this.projectList = projectList;
	}

	private static final long serialVersionUID = -2265837750689865655L;

}
