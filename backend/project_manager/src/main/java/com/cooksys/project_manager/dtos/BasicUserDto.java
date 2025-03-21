package com.cooksys.project_manager.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BasicUserDto {

    //
    private Long id;

    private ProfileDto profile;

    private boolean isAdmin;

    private boolean active;

    private String status;

}
