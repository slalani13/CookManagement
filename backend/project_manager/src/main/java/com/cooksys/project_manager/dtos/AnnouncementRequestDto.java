package com.cooksys.project_manager.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnnouncementRequestDto {

    private String title;
    private String message;
    private Long companyId;
    private Long authorId;

}
