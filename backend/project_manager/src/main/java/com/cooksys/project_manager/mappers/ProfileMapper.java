package com.cooksys.project_manager.mappers;

import org.mapstruct.Mapper;

import com.cooksys.project_manager.dtos.ProfileRequestDto;
import com.cooksys.project_manager.embeddables.Profile;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
  
    Profile requestDtoToEntity(ProfileRequestDto profileRequestDto);

    ProfileRequestDto entityToReqDto(Profile profile);
}