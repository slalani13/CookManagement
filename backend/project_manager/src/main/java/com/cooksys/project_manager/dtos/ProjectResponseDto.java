package com.cooksys.project_manager.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProjectResponseDto {
    
    private String name;

    private String description;

    private TeamResponseDto team;

    private boolean active;

}
