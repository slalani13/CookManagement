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
import com.cooksys.project_manager.dtos.TeamRequestDto;
import com.cooksys.project_manager.dtos.TeamResponseDto;
import com.cooksys.project_manager.services.TeamService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teams")

public class TeamController {
    private final TeamService teamService;

    @GetMapping
    public List<TeamResponseDto> getTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/company/{company_id}")
    public List<TeamResponseDto> getTeamsOfCompany(@PathVariable Long company_id) {
        return teamService.getTeamsOfCompany(company_id);
    }
    
    @GetMapping("/{team_id}")
    public TeamResponseDto getTeam(@PathVariable Long team_id) {
        return teamService.getTeam(team_id);
    }

    @PostMapping
    public TeamResponseDto createTeam(@RequestBody TeamRequestDto teamRequestDto, @RequestBody CredentialsDto credentialsDto) {
        return teamService.createTeam(teamRequestDto, credentialsDto);
    }

    @PatchMapping("/{team_id}/update")
    public TeamResponseDto updateTeam(@PathVariable Long team_id, @RequestBody TeamRequestDto teamRequestDto, @RequestBody CredentialsDto credentialsDto) {
        return teamService.updateTeam(team_id, teamRequestDto, credentialsDto);
    }

    @PatchMapping("/{team_id}/add/{user_id}")
    public TeamResponseDto addToTeam(@PathVariable Long team_id, @PathVariable Long user_id, @RequestBody CredentialsDto credentialsDto) {
        return teamService.addToTeam(team_id, user_id, credentialsDto);
    }

    @PatchMapping("/{team_id}/remove/{user_id}")
    public TeamResponseDto removeFromTeam(@PathVariable Long team_id, @PathVariable Long user_id, @RequestBody CredentialsDto credentialsDto) {
        return teamService.removeFromTeam(team_id, user_id, credentialsDto);
    }

    @DeleteMapping("/{team_id}")
    public String deleteTeam(@PathVariable Long team_id, @RequestBody CredentialsDto credentialsDto) {
        return teamService.deleteTeam(team_id, credentialsDto);
    }

    @PostMapping("/{team_id}/restore")
    public TeamResponseDto restoreTeam(@PathVariable Long team_id, @RequestBody CredentialsDto credentialsDto) {
        return teamService.restoreTeam(team_id, credentialsDto);
    }


    
}
