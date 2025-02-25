package com.cooksys.project_manager.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data

public class TeamRequestDto {
    
    private Long id;
    
    private String name;

    private String description;

    private CompanyResponseDto company;
    
}
