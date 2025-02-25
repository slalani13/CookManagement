package com.cooksys.project_manager.services;

import com.cooksys.project_manager.dtos.UserRequestDto;
import com.cooksys.project_manager.dtos.UserResponseDto;

public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);
    
}
