package com.cooksys.project_manager.dtos;

import java.util.List;

import com.cooksys.project_manager.entities.Team;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CompanyResponseDto {
    
    //
    private Long id;

    private String name;

    private String description;

    private List<TeamResponseDto> teams;

    private List<BasicUserDto> users;

}
