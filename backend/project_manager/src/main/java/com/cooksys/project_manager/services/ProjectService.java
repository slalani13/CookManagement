package com.cooksys.project_manager.services;

import java.util.List;

import com.cooksys.project_manager.dtos.ProjectResponseDto;

public interface ProjectService {
    List<ProjectResponseDto> getAllProjects();

    ProjectResponseDto createProject();
}
