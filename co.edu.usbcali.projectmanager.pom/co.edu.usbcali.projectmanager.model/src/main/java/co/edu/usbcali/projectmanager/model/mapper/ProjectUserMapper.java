package co.edu.usbcali.projectmanager.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.usbcali.projectmanager.model.dto.ProjectUserDirectorNameDTO;
import co.edu.usbcali.projectmanager.model.entities.Project;

@Mapper
public interface ProjectUserMapper {

	ProjectUserMapper INSTANCE = Mappers.getMapper(ProjectUserMapper.class);

	    ProjectUserDirectorNameDTO projectToDto(Project project);
	    
	    List<ProjectUserDirectorNameDTO> projectUserDirectorNameDTOs(List<ProjectUserDirectorNameDTO> directorNameDTOs);
	    
}
