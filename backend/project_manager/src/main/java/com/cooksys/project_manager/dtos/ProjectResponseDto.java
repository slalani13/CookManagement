package com.cooksys.project_manager.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProjectResponseDto {

    private Long id;
    
    private String name;

    private String description;

    private Long team;

    private boolean active;

}
