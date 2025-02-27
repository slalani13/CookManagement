package com.cooksys.project_manager.services.impl;

import com.cooksys.project_manager.dtos.CredentialsDto;
import com.cooksys.project_manager.dtos.FullUserDto;
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

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
//    private final CredentialsMapper credentialsMapper;
    private final ProfileMapper profileMapper;

    @Override
    public FullUserDto createUser(UserRequestDto userRequestDto) {
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
        user.setCompanies(new ArrayList<>());
        user.setTeams(new ArrayList<>());
        userRepository.save(user);
        FullUserDto response = userMapper.entityToFullUserDto(user);
        System.out.println("Returning response: " + response);
        return response;
    }

    @Override
    public FullUserDto activateUser(CredentialsDto credentialsDto) {
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
        return userMapper.entityToFullUserDto(user);
    }

    @Override
    public FullUserDto deleteUser( Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty() || !optionalUser.get().isActive()) {
            throw new IllegalArgumentException("id not found or already deleted");
        }
        User user = optionalUser.get();
        user.setActive(false);
        userRepository.save(user);
        return userMapper.entityToFullUserDto(user);
    }

    @Override
    public FullUserDto getUserById(Long id) {
        Optional<User>  optionalUser = userRepository.findByIdAndIsActiveTrue(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("user not found");
        }
        return userMapper.entityToFullUserDto(optionalUser.get());
    }

//    private User getUser(Long id) {
//        Optional<User>  optionalUser = userRepository.findByIdAndIsActiveTrue(id);
//        if (optionalUser.isEmpty()) {
//            throw new NotFoundException("user not found");
//        }
//        return optionalUser.get();
//    }


    @Override
    public FullUserDto updateUserProfile(Long id, Profile profile) {
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

        return userMapper.entityToFullUserDto(user);
    }

    @Override
    public void logoutUser(FullUserDto fullUserDto) {
        Optional<User> optionalUser = userRepository.findById(fullUserDto.getId());
        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("User not found!!");
        }
        User user = optionalUser.get();
        user.setStatus("inactive");
        userRepository.save(user);
    }
}
