package com.cooksys.project_manager.services.impl;

import com.cooksys.project_manager.dtos.CredentialsDto;
import com.cooksys.project_manager.dtos.UserRequestDto;
import com.cooksys.project_manager.dtos.UserResponseDto;
import com.cooksys.project_manager.entities.User;
import com.cooksys.project_manager.mappers.UserMapper;
import com.cooksys.project_manager.repositories.UserRepository;
import com.cooksys.project_manager.exceptions.*;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cooksys.project_manager.services.ValidationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ValidationServiceImpl implements ValidationService{

    private final UserRepository userRepository;
    
    // verify that the user has admin privilege
    public User hasAuthorization(User user){
        if (!user.isAdmin()){
            throw new NotAuthorizedException(String.format("User with username %s is not an admin", user.getCredentials().getUsername()));
        }
        return user;
    }

    // verify that the credentials match the username and the user is active
    public User verifyCredentials(CredentialsDto credentialsDto){
        isValidCredentials(credentialsDto);
        Optional<User> optionalUser = userRepository.findByCredentialsUsernameAndIsActiveTrue(credentialsDto.getUsername());
        if (!optionalUser.isPresent()){
            throw new BadRequestException(String.format("User with username %s is not present", optionalUser.get().getCredentials().getUsername()));
        }
        if (!optionalUser.get().isActive()){
            throw new BadRequestException(String.format("User with username %s was deactivated", optionalUser.get().getCredentials().getUsername()));
        }
        return optionalUser.get();
    }

    // checks whether the credentials request has valid fields
    public void isValidCredentials(CredentialsDto credentialsRequestDto){
        if (credentialsRequestDto == null){
        throw new BadRequestException(String.format("Credentials are missing in user request"));
        }
        if (credentialsRequestDto.getUsername() == null || credentialsRequestDto.getPassword() == null){
        throw new BadRequestException(String.format("Either username or password are missing in credentials request"));
        }
    }

}
