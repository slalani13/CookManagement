package com.cooksys.project_manager.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.project_manager.dtos.ProjectRequestDto;
import com.cooksys.project_manager.dtos.ProjectResponseDto;
import com.cooksys.project_manager.entities.Project;
import com.cooksys.project_manager.mappers.ProjectMapper;
import com.cooksys.project_manager.mappers.TeamMapper;
import com.cooksys.project_manager.repositories.ProjectRepository;
import com.cooksys.project_manager.services.ProjectService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final TeamMapper teamMapper;

    @Override   
    public List<ProjectResponseDto> getAllProjects() {
        return projectMapper.entitiesToDtos(projectRepository.findByAllByActive());
    }

    @Override
    public ProjectResponseDto createProject(ProjectRequestDto projectRequestDto) {
        Project newProject = projectRepository.save(projectMapper.requestDtoToEntity(projectRequestDto));
        newProject.setActive(false);
        newProject.setName(projectRequestDto.getName());
        newProject.setDescription(projectRequestDto.getDescription());
        newProject.setTeam(teamMapper.responseDtoToEntity(projectRequestDto.getTeam()));
        return projectMapper.entityToResponseDto(projectRepository.save(newProject));
    }
    
}
