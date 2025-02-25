package com.cooksys.project_manager.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.project_manager.dtos.TeamResponseDto;
import com.cooksys.project_manager.services.TeamService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")

public class TeamController {
    private final TeamService teamService;

    @GetMapping("/{id}/teams")
    public List<TeamResponseDto> getTeams() {
        return null;
    }
    
    @GetMapping
    public TeamResponseDto getTeam() {
        return null;
    }

    @PostMapping("/team")
    public TeamResponseDto createTeam() {
        return null;
    }

    @PatchMapping("/team/update")
    public TeamResponseDto updateTeam() {
        return null;
    }
    
}
