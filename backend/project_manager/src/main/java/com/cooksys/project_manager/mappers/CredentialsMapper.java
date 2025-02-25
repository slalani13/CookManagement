package com.cooksys.project_manager.mappers;

import org.mapstruct.Mapper;

import com.cooksys.project_manager.dtos.CredentialsDto;
import com.cooksys.project_manager.entities.Credentials;

@Mapper(componentModel = "spring")
public interface CredentialsMapper {
  
    Credentials requestDtoToEntity(CredentialsDto credentialsRequestDto);

    CredentialsDto entityToReqDto(Credentials credentials);
}
