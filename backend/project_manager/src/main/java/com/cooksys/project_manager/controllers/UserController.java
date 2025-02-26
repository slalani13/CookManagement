package com.cooksys.project_manager.controllers;

import com.cooksys.project_manager.dtos.CredentialsDto;
import com.cooksys.project_manager.entities.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.cooksys.project_manager.dtos.UserRequestDto;
import com.cooksys.project_manager.dtos.UserResponseDto;
import com.cooksys.project_manager.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")

public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto userLogin(@RequestBody CredentialsDto credentialsDto) {
        return userService.activateUser(credentialsDto);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

    @PatchMapping("update/{id}")
    public UserResponseDto updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        return userService.updateUserProfile(id, profile);
    }

    @DeleteMapping("/{id}")
    public UserResponseDto deactivateUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
