package com.cooksys.project_manager.services;

import java.util.List;

import com.cooksys.project_manager.dtos.TeamResponseDto;

public interface TeamService {
    List<TeamResponseDto> getAllTeams();

    TeamResponseDto createTeam();
}
