package com.cooksys.project_manager.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class Profile {

    private String firstName;

    private String lastName;

    private String email;

    private String phone;
}
