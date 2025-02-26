package com.cooksys.project_manager.dtos;


import lombok.NoArgsConstructor;

import lombok.Data;

@NoArgsConstructor
@Data
public class ProfileDto {

    private String firstName;

    private String lastName;

    private String email;

    private String phone;
    
}
