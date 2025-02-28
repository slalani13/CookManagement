package com.cooksys.project_manager.services;

import java.util.List;

import com.cooksys.project_manager.dtos.ContentRequestDto;
import com.cooksys.project_manager.dtos.ProjectRequestDto;
import com.cooksys.project_manager.dtos.ProjectResponseDto;

public interface ProjectService {

    List<ProjectResponseDto> getAllProjects();
    ProjectResponseDto createProject(Long team_id, ProjectRequestDto projectRequestDto);
    ProjectResponseDto updateProject(Long project_id, ProjectRequestDto projectRequestDto);
    ProjectResponseDto updateProjectContent(Long project_id, ContentRequestDto contentRequestDto);
    ProjectResponseDto getProject(Long project_id);
    String fullyDeleteProject(Long project_id);
    List<ProjectResponseDto> getCompanyProjectsOfTeam(Long team_id);


}
