package com.cooksys.project_manager.services;

import java.util.List;

import com.cooksys.project_manager.dtos.AnnouncementResponseDto;
import com.cooksys.project_manager.dtos.CompanyRequestDto;
import com.cooksys.project_manager.dtos.CompanyResponseDto;
import com.cooksys.project_manager.dtos.UserResponseDto;

public interface CompanyService {

    List<UserResponseDto> getUsers(Long id);

    List<CompanyResponseDto> getCompanies();

    CompanyResponseDto getCompany(Long id);

    AnnouncementResponseDto createCompany(CompanyRequestDto companyRequestDto);

    CompanyResponseDto updateCompany(Long id);

    CompanyResponseDto deleteCompany(Long id);

}
