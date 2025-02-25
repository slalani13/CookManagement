package com.cooksys.project_manager.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.project_manager.dtos.CredentialsDto;
import com.cooksys.project_manager.dtos.ProjectRequestDto;
import com.cooksys.project_manager.dtos.ProjectResponseDto;
import com.cooksys.project_manager.services.ProjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")

public class ProjectController {
    private final ProjectService projectService;

    @GetMapping
    public List<ProjectResponseDto> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/teams/{team_id}")
    public List<ProjectResponseDto> getCompanyProjectsOfTeam(@PathVariable Long team_id) {
        return projectService.getCompanyProjectsOfTeam(team_id);
    }

    @GetMapping("/{project_id}")
    public ProjectResponseDto getProject(@PathVariable Long project_id) {
        return projectService.getProject(project_id);
    }

    @PostMapping
    public ProjectResponseDto createProject(@RequestBody ProjectRequestDto projectRequestDto, @RequestBody CredentialsDto credentialsDto) {
        return projectService.createProject(projectRequestDto, credentialsDto);
    }

    @PatchMapping("/{project_id}")
    public ProjectResponseDto updateProject(@PathVariable Long project_id, @RequestBody ProjectRequestDto projectRequestDto, 
                                            @RequestBody CredentialsDto credentialsDto) {                 
        return projectService.updateProject(project_id, projectRequestDto, credentialsDto);
    }
    
    @DeleteMapping("/{project_id}")
    public String fullyDeleteProject(@PathVariable Long project_id, @RequestBody CredentialsDto credentialsDto) {                 
        return projectService.fullyDeleteProject(project_id, credentialsDto);
    }

}
