package com.cooksys.project_manager.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.project_manager.dtos.CompanyRequestDto;
import com.cooksys.project_manager.dtos.UserResponseDto;
import com.cooksys.project_manager.entities.Company;
import com.cooksys.project_manager.entities.User;



@Mapper(componentModel = "spring", uses = { UserMapper.class})

public interface CompanyMapper {
    
    Company requestDtoToEntity(CompanyRequestDto companyRequestDto);

    CompanyRequestDto entityToReqDto(Company company);

    List<UserResponseDto> entitiesToDto(List<User> users);
}
