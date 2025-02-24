package com.cooksys.project_manager.dtos;

import jakarta.persistence.Embedded;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProjectResponseDto {
    @Embedded
    MetaDataRequestDto metaData;

    TeamResponseDto team;

}
