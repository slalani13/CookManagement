package com.cooksys.project_manager.services;

import java.util.List;

import com.cooksys.project_manager.dtos.UserResponseDto;

public interface CompanyService {

    List<UserResponseDto> getUsers(Long id);

}
