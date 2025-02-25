package com.cooksys.project_manager.services;

import java.util.List;

import com.cooksys.project_manager.dtos.CredentialsDto;
import com.cooksys.project_manager.dtos.ProjectRequestDto;
import com.cooksys.project_manager.dtos.ProjectResponseDto;

public interface ProjectService {

    List<ProjectResponseDto> getAllProjects();
    ProjectResponseDto createProject(Long team_id, ProjectRequestDto projectRequestDto, CredentialsDto credentialsDto);
    ProjectResponseDto updateProject(Long project_id, ProjectRequestDto projectRequestDto, CredentialsDto credentialsDto);
    ProjectResponseDto getProject(Long project_id);
    String fullyDeleteProject(Long project_id, CredentialsDto credentialsDto);
    List<ProjectResponseDto> getCompanyProjectsOfTeam(Long team_id);


}
