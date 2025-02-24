package com.cooksys.project_manager.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.project_manager.services.CompanyService;
import com.cooksys.project_manager.dtos.UserResponseDto;
import com.cooksys.project_manager.mappers.CompanyMapper;
import com.cooksys.project_manager.mappers.UserMapper;
import com.cooksys.project_manager.repositories.CompanyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final UserMapper userMapper;

    public List<UserResponseDto> getUsers(Long id) {
        return userMapper.entitiesToDto(companyRepository.findAllByIdAndDeletedFalse(id));
    } 

}
