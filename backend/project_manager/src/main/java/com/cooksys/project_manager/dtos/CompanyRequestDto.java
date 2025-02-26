package com.cooksys.project_manager.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CompanyRequestDto {

    private String name;

    private String description;

    private List<TeamRequestDto> teams;

    private List<UserRequestDto> users;
    
}
