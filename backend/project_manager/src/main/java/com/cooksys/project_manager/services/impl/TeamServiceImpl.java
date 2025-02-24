package com.cooksys.project_manager.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.project_manager.dtos.TeamResponseDto;
import com.cooksys.project_manager.mappers.TeamMapper;
import com.cooksys.project_manager.repositories.TeamRepository;
import com.cooksys.project_manager.services.TeamService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService{
    
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Override
    public List<TeamResponseDto> getAllTeams() {
        return teamMapper.entitiesToDtos(teamRepository.findAll());
    }

    @Override
    public TeamResponseDto createTeam() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createTeam'");
    }
    
}
