package com.cooksys.project_manager.services;

import java.util.List;

import com.cooksys.project_manager.dtos.AnnouncementResponseDto;
import com.cooksys.project_manager.dtos.CompanyRequestDto;
import com.cooksys.project_manager.dtos.CompanyResponseDto;
import com.cooksys.project_manager.dtos.FullUserDto;
import com.cooksys.project_manager.dtos.UserResponseDto;

public interface CompanyService {

    List<FullUserDto> getUsers(Long id);

    List<CompanyResponseDto> getCompanies();

    CompanyResponseDto getCompany(Long id);

    CompanyResponseDto createCompany(CompanyRequestDto companyRequestDto);

    CompanyResponseDto updateCompany(Long id, CompanyRequestDto companyRequestDto);

    CompanyResponseDto deleteCompany(Long id);

}
