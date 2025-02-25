package com.cooksys.project_manager.services;

import java.util.Optional;

import com.cooksys.project_manager.dtos.CredentialsDto;
import com.cooksys.project_manager.entities.User;
import com.cooksys.project_manager.exceptions.NotAuthorizedException;

public interface ValidationService {

    User hasAuthorization(User user);
    User verifyCredentials(CredentialsDto credentialsDto);
    void isValidCredentials(CredentialsDto credentialsRequestDto);
    
}
