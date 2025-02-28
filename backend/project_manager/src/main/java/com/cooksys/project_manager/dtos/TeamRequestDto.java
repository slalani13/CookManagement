package com.cooksys.project_manager.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data

public class TeamRequestDto {
    
    private String name;

    private String description;

    private Long company;
    
}
