package com.cooksys.project_manager.services;

import com.cooksys.project_manager.dtos.CredentialsDto;
import com.cooksys.project_manager.dtos.FullUserDto;
import com.cooksys.project_manager.dtos.UserRequestDto;
import com.cooksys.project_manager.dtos.UserResponseDto;
import com.cooksys.project_manager.entities.Profile;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserService {

    FullUserDto createUser(UserRequestDto userRequestDto);

    UserResponseDto activateUser(CredentialsDto credentialsDto);

    UserResponseDto deleteUser( Long id);

    UserResponseDto getUserById(Long id);

    UserResponseDto updateUserProfile(Long id, Profile profile);
}
