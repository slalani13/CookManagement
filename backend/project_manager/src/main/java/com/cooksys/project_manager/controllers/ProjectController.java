package com.cooksys.project_manager.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.cooksys.project_manager.dtos.ProjectRequestDto;
import com.cooksys.project_manager.dtos.ProjectResponseDto;
import com.cooksys.project_manager.services.ProjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")

public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/{company_id}/teams/{team_id}/projects")
    public List<ProjectResponseDto> getProjects(@PathVariable Long company_id, @PathVariable Long team_id) {
        return projectService.getAllProjects();
    }

    @GetMapping
    public ProjectResponseDto getProject() {
        return null;
    }

    @PostMapping("/project")
    public ProjectResponseDto createProject(@RequestBody ProjectRequestDto projectRequestDto) {
        return projectService.createProject(projectRequestDto);
    }

    @PatchMapping("/project/update")
    public ProjectResponseDto updateProject() {
        return null;
    }
    

}
