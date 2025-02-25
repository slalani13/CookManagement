package com.cooksys.project_manager.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cooksys.project_manager.services.CompanyService;
import com.cooksys.project_manager.dtos.AnnouncementResponseDto;
import com.cooksys.project_manager.dtos.CompanyRequestDto;
import com.cooksys.project_manager.dtos.CompanyResponseDto;
import com.cooksys.project_manager.dtos.UserResponseDto;
import com.cooksys.project_manager.entities.Company;
import com.cooksys.project_manager.exceptions.NotFoundException;
import com.cooksys.project_manager.mappers.CompanyMapper;
import com.cooksys.project_manager.mappers.UserMapper;
import com.cooksys.project_manager.repositories.CompanyRepository;
import com.cooksys.project_manager.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final UserMapper userMapper;
    private final UserRepository userRepository;



    // HELPER 

    public Company validateCompany(Long id) {
        Optional<Company> company = companyRepository.findByIdAndIsDeletedFalse(id);
        if (company.isEmpty()) {
            throw new NotFoundException("No company with id: " + id);
        }
        return company.get();
    }

    // Retrieves a list of all active users that work for the given company. 
    // If the company id provided does not match an active company in the database,
    // an error should be sent in lieu of a response.
    @Override
    public List<UserResponseDto> getUsers(Long id) {
        return userMapper.entitiesToDto(userRepository.findAllByIdAndIsActiveFalse(id));
    }

    @Override
    public List<CompanyResponseDto> getCompanies() {
        return companyMapper.entitiesToDto(companyRepository.findAllByIsDeletedFalse());
    }

    @Override
    public CompanyResponseDto getCompany(Long id) {
        Company company = validateCompany(id);
        return companyMapper.entityToDto(company);
    }

    @Override
    public AnnouncementResponseDto createCompany(CompanyRequestDto companyRequestDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCompany'");
    }

    @Override
    public CompanyResponseDto updateCompany(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCompany'");
    }

    @Override
    public CompanyResponseDto deleteCompany(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCompany'");
    } 

}
