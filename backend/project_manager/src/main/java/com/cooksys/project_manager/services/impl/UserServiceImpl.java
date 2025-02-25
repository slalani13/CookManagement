package com.cooksys.project_manager.services.impl;

import com.cooksys.project_manager.dtos.UserRequestDto;
import com.cooksys.project_manager.dtos.UserResponseDto;
import com.cooksys.project_manager.entities.User;
import com.cooksys.project_manager.mappers.UserMapper;
import org.springframework.stereotype.Service;

import com.cooksys.project_manager.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = userMapper.requestDtoToEntity(userRequestDto);
        // check that profile, credentials, and admin aren't null

        // maybe use validate service to see if user already exists or was deleted

        // else create new user
        return null;
    }

}
