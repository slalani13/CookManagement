package com.cooksys.project_manager.controllers;

import com.cooksys.project_manager.dtos.CredentialsDto;
import com.cooksys.project_manager.dtos.FullUserDto;
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
    public FullUserDto userLogin(@RequestBody CredentialsDto credentialsDto) {
        return userService.activateUser(credentialsDto);
    }

    @GetMapping("/{id}")
    public FullUserDto getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FullUserDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

    @PatchMapping("update/{id}")
    public FullUserDto updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        return userService.updateUserProfile(id, profile);
    }

    @DeleteMapping("/{id}")
    public FullUserDto deactivateUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logoutUser(@RequestBody FullUserDto fullUserDto) {
        userService.logoutUser(fullUserDto);
    }
}
