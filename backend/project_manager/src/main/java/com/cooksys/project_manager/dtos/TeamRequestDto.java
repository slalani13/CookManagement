package com.cooksys.project_manager.dtos;

import jakarta.persistence.Embedded;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data

public class TeamRequestDto {
    @Embedded
    private CredentialsRequestDto credentials;
    
    @Embedded
    private MetaDataRequestDto metaData;

    private CompanyResponseDto company;
}
