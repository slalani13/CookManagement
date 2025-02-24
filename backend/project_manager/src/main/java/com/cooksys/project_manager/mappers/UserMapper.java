package com.cooksys.project_manager.mappers;

import org.mapstruct.Mapper;

import com.cooksys.project_manager.dtos.UserRequestDto;
import com.cooksys.project_manager.dtos.UserResponseDto;
import com.cooksys.project_manager.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User requestDtoToEntity(UserRequestDto teamRequestDto);

    UserResponseDto entityToResponseDto(User team);

}
