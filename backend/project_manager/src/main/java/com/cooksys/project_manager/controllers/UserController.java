package com.cooksys.project_manager.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public UserResponseDto userLogin() {
        return null;
    }

    @GetMapping
    public UserResponseDto getUser() {
        return null;
    }

    @PostMapping
    public UserResponseDto createUser() {
        return null;
    }

    @PatchMapping("/update")
    public UserResponseDto updateProfile() {
        return null;
    }
}
