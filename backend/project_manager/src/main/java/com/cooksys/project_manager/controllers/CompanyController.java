package com.cooksys.project_manager.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.project_manager.dtos.AnnouncementResponseDto;
import com.cooksys.project_manager.dtos.CompanyResponseDto;
import com.cooksys.project_manager.dtos.UserResponseDto;
import com.cooksys.project_manager.services.CompanyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/{id}/users")
    public List<UserResponseDto> getUsers(@PathVariable long id) {
        return companyService.getUsers(id);
    }

    @GetMapping
    public List<CompanyResponseDto> getCompanies() {
        return null;
    }

    @GetMapping("/{id}")
    public CompanyResponseDto getCompany(@PathVariable long id) {
        return null;
    }

    @PostMapping
    public AnnouncementResponseDto createCompany() {
        return null;
    }

    @PatchMapping("/update")
    public CompanyResponseDto updateCompany() {
        return null;
    }

    @DeleteMapping
    public CompanyResponseDto deleteCompany() {
        return null;
    }

}
