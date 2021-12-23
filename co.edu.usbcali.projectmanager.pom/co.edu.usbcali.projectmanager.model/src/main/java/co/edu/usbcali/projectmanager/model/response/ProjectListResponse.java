package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;
import java.util.List;

import co.edu.usbcali.projectmanager.model.entities.Project;

public class ProjectListResponse<T> implements Serializable {

	private List<Project> projectList;

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	private static final long serialVersionUID = -2265837750689865655L;

}
