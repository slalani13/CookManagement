package com.cooksys.project_manager.services;

import com.cooksys.project_manager.dtos.CredentialsDto;
import com.cooksys.project_manager.dtos.FullUserDto;
import com.cooksys.project_manager.dtos.UserRequestDto;
import com.cooksys.project_manager.dtos.UserResponseDto;
import com.cooksys.project_manager.entities.Profile;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserService {

    FullUserDto createUser(UserRequestDto userRequestDto);

    FullUserDto activateUser(CredentialsDto credentialsDto);

    FullUserDto deleteUser( Long id);

    FullUserDto getUserById(Long id);

    FullUserDto updateUserProfile(Long id, Profile profile);
}
