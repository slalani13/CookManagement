package com.cooksys.project_manager.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.project_manager.dtos.TeamResponseDto;
import com.cooksys.project_manager.services.TeamService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class TeamController {
    private final TeamService teamService;

    @GetMapping
    public List<TeamResponseDto> getTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping
    public TeamResponseDto createTeam() {
        return teamService.createTeam();
    }
    
}
