package com.cooksys.project_manager.mappers;

import org.mapstruct.Mapper;

import com.cooksys.project_manager.dtos.ProjectRequestDto;
import com.cooksys.project_manager.entities.Project;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    
    Project requestDtoToEntity(ProjectRequestDto projectRequestDto);

    ProjectRequestDto entityToReqDto(Project project);

}
