package com.cooksys.project_manager.embeddables;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;


@Embeddable
@Data
@NoArgsConstructor

public class MetaData {

    private String name;

    private String description;
}