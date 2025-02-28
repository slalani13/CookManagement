package com.cooksys.project_manager.services;

import java.util.List;

import com.cooksys.project_manager.dtos.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface CompanyService {

    List<FullUserDto> getUsers(Long id);

    List<CompanyResponseDto> getCompanies();

    CompanyResponseDto getCompany(Long id);

    CompanyResponseDto createCompany(CompanyRequestDto companyRequestDto);

    CompanyResponseDto updateCompany(Long id, CompanyRequestDto companyRequestDto);

    CompanyResponseDto deleteCompany(Long id);

    CompanyResponseDto addUserToCompany(Long companyId, CredentialsDto credentialsDto);

}
