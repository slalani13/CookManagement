package com.cooksys.project_manager.services;

import java.util.List;

import com.cooksys.project_manager.dtos.CredentialsDto;
import com.cooksys.project_manager.dtos.TeamRequestDto;
import com.cooksys.project_manager.dtos.TeamResponseDto;

public interface TeamService {

    List<TeamResponseDto> getAllTeams();
    TeamResponseDto getTeam(Long team_id);
    List<TeamResponseDto> getTeamsOfCompany(Long company_id);
    TeamResponseDto createTeam(TeamRequestDto teamRequestDto);
    TeamResponseDto updateTeam(Long team_id, TeamRequestDto teamRequestDto);
    TeamResponseDto addToTeam(Long team_id, Long user_id);
    TeamResponseDto removeFromTeam(Long team_id, Long user_id);
    String deleteTeam(Long team_id);
    TeamResponseDto restoreTeam(Long team_id);

}
