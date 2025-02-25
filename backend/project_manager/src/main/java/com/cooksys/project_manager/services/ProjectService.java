package com.cooksys.project_manager.services;

import java.util.List;

import com.cooksys.project_manager.dtos.CredentialsDto;
import com.cooksys.project_manager.dtos.ProjectRequestDto;
import com.cooksys.project_manager.dtos.ProjectResponseDto;

public interface ProjectService {

    List<ProjectResponseDto> getAllProjects();
    ProjectResponseDto createProject(ProjectRequestDto projectRequestDto, CredentialsDto credentialsDto);
    ProjectResponseDto updateProject(Long project_id, ProjectRequestDto projectRequestDto, CredentialsDto credentialsDto);
    ProjectResponseDto getProject(Long project_id);
    List<ProjectResponseDto> getCompanyProjectsOfTeam(Long team_id);


}
