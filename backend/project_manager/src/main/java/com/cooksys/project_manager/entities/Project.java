package com.cooksys.project_manager.entities;

import com.cooksys.project_manager.embeddables.MetaData;

import jakarta.persistence.Embedded;
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

    @Embedded
    private MetaData metaData;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

}
