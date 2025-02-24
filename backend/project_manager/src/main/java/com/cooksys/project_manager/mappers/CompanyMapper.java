package com.cooksys.project_manager.mappers;

import org.mapstruct.Mapper;

import com.cooksys.project_manager.dtos.CompanyRequestDto;
import com.cooksys.project_manager.entities.Company;



@Mapper(componentModel = "spring")

public interface CompanyMapper {
    
    Company requestDtoToEntity(CompanyRequestDto companyRequestDto);

    CompanyRequestDto entityToReqDto(Company company);
}
