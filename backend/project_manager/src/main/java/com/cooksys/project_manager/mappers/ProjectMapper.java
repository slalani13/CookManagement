package com.cooksys.project_manager.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.project_manager.dtos.ProjectRequestDto;
import com.cooksys.project_manager.dtos.ProjectResponseDto;
import com.cooksys.project_manager.dtos.TeamResponseDto;
import com.cooksys.project_manager.entities.Project;
import com.cooksys.project_manager.entities.Team;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    
    Project requestDtoToEntity(ProjectRequestDto projectRequestDto);

    ProjectResponseDto entityToResponseDto(Project project);

    List<ProjectResponseDto> entitiesToDtos(List<Project> entities);

}
