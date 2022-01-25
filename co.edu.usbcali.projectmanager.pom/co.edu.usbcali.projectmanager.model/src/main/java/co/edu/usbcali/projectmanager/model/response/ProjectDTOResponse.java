package co.edu.usbcali.projectmanager.model.response;

import java.io.Serializable;

import co.edu.usbcali.projectmanager.model.dto.ProjectsListDTO;

public class ProjectDTOResponse implements Serializable {

	private ProjectsListDTO projectsListDTO;

	public ProjectsListDTO getProjectsListDTO() {
		return projectsListDTO;
	}

	public void setProjectsListDTO(ProjectsListDTO projectsListDTO) {
		this.projectsListDTO = projectsListDTO;
	}

	private static final long serialVersionUID = -8315366266777815206L;

}
