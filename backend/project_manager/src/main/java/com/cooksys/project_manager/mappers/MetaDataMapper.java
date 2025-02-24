package com.cooksys.project_manager.mappers;

import org.mapstruct.Mapper;

import com.cooksys.project_manager.dtos.MetaDataRequestDto;
import com.cooksys.project_manager.embeddables.MetaData;

@Mapper(componentModel = "spring")
public interface MetaDataMapper {
  
    MetaData requestDtoToEntity(MetaDataRequestDto credentialsRequestDto);

    MetaDataRequestDto entityToReqDto(MetaData credentials);
}
