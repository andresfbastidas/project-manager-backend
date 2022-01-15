package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;

import co.edu.usbcali.projectmanager.model.commons.PagedCustom;
import co.edu.usbcali.projectmanager.model.entities.Project;

public class ProjectListByStateResponse<T> implements Serializable {

	List<Project> projectList;
	private Pageable pagable;
	private PagedCustom pagedCustom;

	public Pageable getPagable() {
		return pagable;
	}

	public void setPagable(Pageable pagable) {
		this.pagable = pagable;
	}

	public PagedCustom getPagedCustom() {
		return pagedCustom;
	}

	public void setPagedCustom(PagedCustom pagedCustom) {
		this.pagedCustom = pagedCustom;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	private static final long serialVersionUID = -2876013579938168944L;

}
