package com.cooksys.project_manager.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.project_manager.dtos.TeamRequestDto;
import com.cooksys.project_manager.dtos.TeamResponseDto;
import com.cooksys.project_manager.entities.Team;


@Mapper(componentModel = "spring")

public interface TeamMapper {

    Team requestDtoToEntity(TeamRequestDto teamRequestDto);

    Team responseDtoToEntity(TeamResponseDto teamResponseDto);

    TeamResponseDto entityToResponseDto(Team team);

    List<TeamResponseDto> entitiesToDtos(List<Team> entities);

    List<Team> dtosToEntities(List<TeamRequestDto> teams);
    
}
