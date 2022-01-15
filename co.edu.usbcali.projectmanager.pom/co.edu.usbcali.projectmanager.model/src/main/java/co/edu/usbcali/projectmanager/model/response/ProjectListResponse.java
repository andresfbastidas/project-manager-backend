package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;

import co.edu.usbcali.projectmanager.model.commons.PagedCustom;
import co.edu.usbcali.projectmanager.model.dto.ProjectUserDirectorNameDTO;

public class ProjectListResponse<T> implements Serializable {

	private List<ProjectUserDirectorNameDTO> projectList;
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

	public List<ProjectUserDirectorNameDTO> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<ProjectUserDirectorNameDTO> projectList) {
		this.projectList = projectList;
	}

	private static final long serialVersionUID = -2265837750689865655L;

}
