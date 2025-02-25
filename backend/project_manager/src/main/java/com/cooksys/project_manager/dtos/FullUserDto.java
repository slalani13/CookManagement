package com.cooksys.project_manager.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FullUserDto {

    private Long id;

    private ProfileDto profile;

    private boolean isAdmin;

    private boolean active;

    private String status;

    private List<CompanyResponseDto> companies;

    private List<TeamResponseDto> teams;

}
