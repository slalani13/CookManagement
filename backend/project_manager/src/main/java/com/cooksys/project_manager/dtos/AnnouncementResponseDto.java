package com.cooksys.project_manager.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnnouncementResponseDto {

    private Long id;
    private String title;
    private String message;
    private BasicUserDto author;
    
}
