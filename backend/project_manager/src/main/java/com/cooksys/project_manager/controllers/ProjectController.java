package com.cooksys.project_manager.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.project_manager.dtos.ProjectRequestDto;
import com.cooksys.project_manager.dtos.ProjectResponseDto;
import com.cooksys.project_manager.services.ProjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")

public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/{id}/teams/{id}/projects")
    public List<ProjectResponseDto> getProjects() {
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
