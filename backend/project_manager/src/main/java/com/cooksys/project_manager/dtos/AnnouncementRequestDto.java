package com.cooksys.project_manager.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class AnnouncementRequestDto {

    private Timestamp date;
    private String title;
    private String message;
//    still unsure which way to proceed with dto or id
    private Long companyId;
    private Long authorId;
    private BasicUserDto author;

}
