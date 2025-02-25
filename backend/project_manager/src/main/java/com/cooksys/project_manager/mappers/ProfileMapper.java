package com.cooksys.project_manager.mappers;

import com.cooksys.project_manager.dtos.ProfileDto;
import org.mapstruct.Mapper;

import com.cooksys.project_manager.entities.Profile;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
  
    Profile requestDtoToEntity(ProfileDto profileRequestDto);

    ProfileDto entityToReqDto(Profile profile);
}