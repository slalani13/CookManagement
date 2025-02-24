package com.cooksys.project_manager.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.project_manager.dtos.ProjectResponseDto;
import com.cooksys.project_manager.mappers.ProjectMapper;
import com.cooksys.project_manager.repositories.ProjectRepository;
import com.cooksys.project_manager.services.ProjectService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override   
    public List<ProjectResponseDto> getAllProjects() {
        return projectMapper.entitiesToDtos(projectRepository.findByAllByActive());
    }

    @Override
    public ProjectResponseDto createProject() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createProject'");
    }
    
}
