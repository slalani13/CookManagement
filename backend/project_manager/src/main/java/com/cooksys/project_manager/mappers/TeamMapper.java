package com.cooksys.project_manager.mappers;

import org.mapstruct.Mapper;

import com.cooksys.project_manager.dtos.TeamRequestDto;
import com.cooksys.project_manager.entities.Team;


@Mapper(componentModel = "spring")

public interface TeamMapper {

    Team requestDtoToEntity(TeamRequestDto teamRequestDto);

    TeamRequestDto entityToReqDto(Team team);
    
}
