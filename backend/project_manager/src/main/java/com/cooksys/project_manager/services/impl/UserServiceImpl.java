package com.cooksys.project_manager.services.impl;

import com.cooksys.project_manager.dtos.CredentialsDto;
import com.cooksys.project_manager.dtos.UserRequestDto;
import com.cooksys.project_manager.dtos.UserResponseDto;
import com.cooksys.project_manager.entities.Credentials;
import com.cooksys.project_manager.entities.User;
import com.cooksys.project_manager.mappers.CredentialsMapper;
import com.cooksys.project_manager.mappers.UserMapper;
import com.cooksys.project_manager.repositories.UserRepository;
import org.springframework.stereotype.Service;

import com.cooksys.project_manager.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final CredentialsMapper credentialsMapper;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = userMapper.requestDtoToEntity(userRequestDto);
        // check that profile, credentials, and admin aren't null
        // Validate required fields
        if (user.getProfile() == null || user.getCredentials() == null) {
            throw new IllegalArgumentException("Profile, Credentials, and Admin fields cannot be null.");
        }
        // maybe use validate service to see if user already exists or was deleted

        // else create new user
        user.setActive(true);
        user.setStatus("inactive");
        userRepository.save(user);
        UserResponseDto response = userMapper.entityToResponseDto(user);
        System.out.println("Returning response: " + response);
        return response;
    }

    @Override
    public UserResponseDto activateUser(CredentialsDto credentialsDto) {
        if (credentialsDto == null || credentialsDto.getUsername() == null || credentialsDto.getPassword() == null) {
            throw new IllegalArgumentException("Username and password cannot be null");
        }
        User user = userRepository.findByCredentialsUsernameAndCredentialsPassword(
                credentialsDto.getUsername(), credentialsDto.getPassword()
        );
        if (user == null) {
            throw new IllegalArgumentException("Credentials do not match any user in the database");
        }
        user.setStatus("active");
        userRepository.save(user);
        return userMapper.entityToResponseDto(user);
    }



}
