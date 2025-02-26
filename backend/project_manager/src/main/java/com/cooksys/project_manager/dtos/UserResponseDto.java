package com.cooksys.project_manager.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserResponseDto {

// <<<<<<< shariq_backend
//     private String username;

//     private ProfileDto profile;
    
// =======
    private Long id;

    private String username;

    private ProfileDto profile;

    private boolean isAdmin;

    private boolean active;

    private String status;

}

