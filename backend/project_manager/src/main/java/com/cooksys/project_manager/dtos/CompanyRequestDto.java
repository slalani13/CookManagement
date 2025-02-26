package com.cooksys.project_manager.dtos;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyRequestDto {

    private String name;

    private String description;

    private List<TeamRequestDto> teams;

    private List<UserRequestDto> users;
    
}
