package com.cooksys.project_manager.services;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cooksys.project_manager.dtos.CredentialsDto;
import com.cooksys.project_manager.dtos.TeamRequestDto;
import com.cooksys.project_manager.dtos.TeamResponseDto;

public interface TeamService {

    List<TeamResponseDto> getAllTeams();
    TeamResponseDto getTeam(Long team_id);
    TeamResponseDto createTeam(TeamRequestDto teamRequestDto, CredentialsDto credentialsDto);
    TeamResponseDto updateTeam(Long team_id, TeamRequestDto teamRequestDto, CredentialsDto credentialsDto);
    TeamResponseDto addToTeam(Long team_id, Long user_id, CredentialsDto credentialsDto);
    TeamResponseDto removeFromTeam(Long team_id, Long user_id, CredentialsDto credentialsDto);
    String deleteTeam(Long team_id, CredentialsDto credentialsDto);
    TeamResponseDto restoreTeam(Long team_id, CredentialsDto credentialsDto);

}
