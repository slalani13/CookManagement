package com.cooksys.project_manager.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.project_manager.dtos.CompanyRequestDto;
import com.cooksys.project_manager.dtos.CompanyResponseDto;
import com.cooksys.project_manager.dtos.UserResponseDto;
import com.cooksys.project_manager.entities.Company;
import com.cooksys.project_manager.entities.User;



@Mapper(componentModel = "spring", uses = { UserMapper.class, ProfileMapper.class})

public interface CompanyMapper {
    
    Company requestDtoToEntity(CompanyRequestDto companyRequestDto);

    Company responseDtoToEntity(CompanyResponseDto companyResponseDto);

    CompanyRequestDto entityToReqDto(Company company);

    CompanyResponseDto entityToDto(Company company);

    List<CompanyResponseDto> entitiesToDto(List<Company> companies);
}
