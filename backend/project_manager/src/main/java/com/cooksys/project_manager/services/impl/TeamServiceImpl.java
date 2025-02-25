package com.cooksys.project_manager.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.project_manager.dtos.TeamRequestDto;
import com.cooksys.project_manager.dtos.TeamResponseDto;
import com.cooksys.project_manager.entities.Team;
import com.cooksys.project_manager.mappers.CompanyMapper;
import com.cooksys.project_manager.mappers.TeamMapper;
import com.cooksys.project_manager.repositories.TeamRepository;
import com.cooksys.project_manager.services.TeamService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService{
    
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;
    private final CompanyMapper companyMapper;

    @Override
    public List<TeamResponseDto> getAllTeams() {
        return teamMapper.entitiesToDtos(teamRepository.findAll());
    }

    @Override
    public TeamResponseDto createTeam(TeamRequestDto teamRequestDto) {
        Team newTeam = teamRepository.save(teamMapper.requestDtoToEntity(teamRequestDto));
        newTeam.setName(teamRequestDto.getName());
        newTeam.setDescription(teamRequestDto.getDescription());
        newTeam.setCompany(companyMapper.responseDtoToEntity(teamRequestDto.getCompany()));
        return teamMapper.entityToResponseDto(teamRepository.save(newTeam));
    }
    
}
