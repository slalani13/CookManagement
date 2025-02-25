package com.cooksys.project_manager.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cooksys.project_manager.dtos.UserRequestDto;
import com.cooksys.project_manager.dtos.UserResponseDto;
import com.cooksys.project_manager.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User requestDtoToEntity(UserRequestDto userRequestDto);

    UserResponseDto entityToResponseDto(User user);

    List<UserResponseDto> entitiesToDto(List<User> entities);

}
