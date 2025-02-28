package com.cooksys.project_manager.controllers;

import java.util.List;

import com.cooksys.project_manager.dtos.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.project_manager.services.CompanyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/{id}/users")
    public List<FullUserDto> getUsers(@PathVariable Long id) {
        return companyService.getUsers(id);
    }

    @GetMapping
    public List<CompanyResponseDto> getCompanies() {
        return companyService.getCompanies();
    }

    @GetMapping("/{id}")
    public CompanyResponseDto getCompany(@PathVariable Long id) {
        return companyService.getCompany(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyResponseDto createCompany(CompanyRequestDto companyRequestDto) {
        return companyService.createCompany(companyRequestDto);
    }

    @PatchMapping("/{id}")
    public CompanyResponseDto updateCompany(@PathVariable Long id, @RequestBody CompanyRequestDto companyRequestDto) {
        return companyService.updateCompany(id, companyRequestDto);
    }

    @PatchMapping("/{companyId}/add-user")
    public CompanyResponseDto addUserToCompany(@PathVariable Long companyId, @RequestBody CredentialsDto credentialsDto) {
        return companyService.addUserToCompany(companyId, credentialsDto);
    }

    @DeleteMapping("/{id}")
    public CompanyResponseDto deleteCompany(@PathVariable Long id) {
        return companyService.deleteCompany(id);
    }

}
