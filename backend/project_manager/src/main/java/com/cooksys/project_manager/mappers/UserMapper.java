package com.cooksys.project_manager.mappers;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cooksys.project_manager.dtos.FullUserDto;
import com.cooksys.project_manager.dtos.UserRequestDto;
import com.cooksys.project_manager.dtos.UserResponseDto;
import com.cooksys.project_manager.entities.User;


@Mapper(componentModel = "spring", uses = { ProfileMapper.class, CredentialsMapper.class })
public interface UserMapper {

    User requestDtoToEntity(UserRequestDto userRequestDto);

    @Mapping(target = "username", source = "credentials.username") // Explicitly map username
    UserResponseDto entityToResponseDto(User user);

    List<FullUserDto> entitiesToDto(Set<User> entities);

    List<User> dtosToEntities(List<UserRequestDto> users);

    FullUserDto entityToFullUserDto(User user);

}
