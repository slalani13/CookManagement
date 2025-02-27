package com.cooksys.project_manager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private boolean isActive;

    private Long team;

    private String content;

}
