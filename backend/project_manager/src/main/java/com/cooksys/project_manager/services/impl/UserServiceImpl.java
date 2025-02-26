package com.cooksys.project_manager.services.impl;

import com.cooksys.project_manager.dtos.CredentialsDto;
import com.cooksys.project_manager.dtos.UserRequestDto;
import com.cooksys.project_manager.dtos.UserResponseDto;
import com.cooksys.project_manager.entities.Credentials;
import com.cooksys.project_manager.entities.Profile;
import com.cooksys.project_manager.entities.User;
import com.cooksys.project_manager.exceptions.BadRequestException;
import com.cooksys.project_manager.exceptions.NotFoundException;
import com.cooksys.project_manager.mappers.CredentialsMapper;
import com.cooksys.project_manager.mappers.ProfileMapper;
import com.cooksys.project_manager.mappers.UserMapper;
import com.cooksys.project_manager.repositories.UserRepository;
import org.springframework.stereotype.Service;

import com.cooksys.project_manager.services.UserService;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
//    private final CredentialsMapper credentialsMapper;
    private final ProfileMapper profileMapper;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = userMapper.requestDtoToEntity(userRequestDto);
        // check that profile, credentials, and admin aren't null
        // Validate required fields
        Boolean isAdmin = user.isAdmin();
        if (user.getProfile() == null || user.getCredentials() == null) {
            throw new IllegalArgumentException("Profile, Credentials, and Admin fields cannot be null.");
        }
        // maybe use validate service to see if user already exists or was deleted

        // else create new user
        user.setActive(true);
        user.setStatus("inactive");
        user.setAdmin(user.isAdmin());
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
        Optional<User> optionalUser = userRepository.findByCredentialsUsernameAndCredentialsPassword(
                credentialsDto.getUsername(), credentialsDto.getPassword()
        );
        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("Credentials do not match any user in the database");
        }
        User user = optionalUser.get();
        user.setStatus("active");
        userRepository.save(user);
        return userMapper.entityToResponseDto(user);
    }

    @Override
    public UserResponseDto deleteUser( Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty() || !optionalUser.get().isActive()) {
            throw new IllegalArgumentException("id not found or already deleted");
        }
        User user = optionalUser.get();
        user.setActive(false);
        userRepository.save(user);
        return userMapper.entityToResponseDto(user);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        Optional<User>  optionalUser = userRepository.findByIdAndIsActiveTrue(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("user not found");
        }
        return userMapper.entityToResponseDto(optionalUser.get());
    }

//    private User getUser(Long id) {
//        Optional<User>  optionalUser = userRepository.findByIdAndIsActiveTrue(id);
//        if (optionalUser.isEmpty()) {
//            throw new NotFoundException("user not found");
//        }
//        return optionalUser.get();
//    }


    @Override
    public UserResponseDto updateUserProfile(Long id, Profile profile) {
        Optional<User> optionalUser = userRepository.findByIdAndIsActiveTrue(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("user not found");
        }
        User user = optionalUser.get();
        Profile userProfile = user.getProfile();
        if (profile == null) {
            throw new BadRequestException("Profile data is required");
        }
        if (profile.getFirstName() == null || profile.getLastName() == null || profile.getEmail() == null || profile.getPhone() == null ) {
            throw new BadRequestException("incomplete profile data");
        }

        userProfile.setFirstName(profile.getFirstName());
        userProfile.setLastName(profile.getLastName());
        userProfile.setEmail(profile.getEmail());
        userProfile.setPhone(profile.getPhone());

        userRepository.save(user);

        return userMapper.entityToResponseDto(user);
    }


}
