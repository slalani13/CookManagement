package com.cooksys.project_manager.mappers;

import org.mapstruct.Mapper;

import com.cooksys.project_manager.dtos.CredentialsRequestDto;
import com.cooksys.project_manager.embeddables.Credentials;

@Mapper(componentModel = "spring")
public interface CredentialsMapper {
  
    Credentials requestDtoToEntity(CredentialsRequestDto credentialsRequestDto);

    CredentialsRequestDto entityToReqDto(Credentials credentials);
}
