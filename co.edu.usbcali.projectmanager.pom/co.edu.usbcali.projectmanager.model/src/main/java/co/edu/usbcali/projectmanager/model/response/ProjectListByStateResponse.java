package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;
import java.util.List;

import co.edu.usbcali.projectmanager.model.dto.ProjectsListDTO;

public class ProjectListByStateResponse<T> implements Serializable {

	List<ProjectsListDTO> projectList;
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

	public List<ProjectsListDTO> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<ProjectsListDTO> projectList) {
		this.projectList = projectList;
	}

	private static final long serialVersionUID = -2876013579938168944L;

}
