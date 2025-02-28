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

import com.cooksys.project_manager.dtos.ContentRequestDto;
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

    @PostMapping("/teams/{team_id}")
    public ProjectResponseDto createProject(@PathVariable Long team_id, @RequestBody ProjectRequestDto projectRequestDto) {
        return projectService.createProject(team_id, projectRequestDto);
    }

    @PatchMapping("/{project_id}")
    public ProjectResponseDto updateProject(@PathVariable Long project_id, @RequestBody ProjectRequestDto projectRequestDto) {                 
        return projectService.updateProject(project_id, projectRequestDto);
    }

    @PatchMapping("/{project_id}/content")
    public ProjectResponseDto updateProjectContent(@PathVariable Long project_id, @RequestBody ContentRequestDto contentRequestDto) {                 
        return projectService.updateProjectContent(project_id, contentRequestDto);
    }
    
    @DeleteMapping("/{project_id}")
    public String fullyDeleteProject(@PathVariable Long project_id) {                 
        return projectService.fullyDeleteProject(project_id);
    }

}
