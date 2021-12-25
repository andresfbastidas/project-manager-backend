package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;
import java.util.List;

import co.edu.usbcali.projectmanager.model.dto.ProjectUserDirectorNameDTO;

public class ProjectListResponse<T> implements Serializable {

	private List<ProjectUserDirectorNameDTO> projectList;

	public List<ProjectUserDirectorNameDTO> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<ProjectUserDirectorNameDTO> projectList) {
		this.projectList = projectList;
	}

	private static final long serialVersionUID = -2265837750689865655L;

}
