package com.cooksys.project_manager.dtos;

import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data

public class TeamRequestDto {
    
    private String name;

    private String description;

    private Long company;

    private Set<BasicUserDto> users;
    
}
