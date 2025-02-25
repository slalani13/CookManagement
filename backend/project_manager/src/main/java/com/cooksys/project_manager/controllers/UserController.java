package com.cooksys.project_manager.controllers;

import com.cooksys.project_manager.dtos.UserRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.cooksys.project_manager.dtos.AnnouncementResponseDto;
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
    public UserResponseDto userLogin() {
        return null;
    }

    @GetMapping
    public UserResponseDto getUser() {
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }


    @PatchMapping("/update")
    public UserResponseDto updateProfile() {
        return null;
    }
}
