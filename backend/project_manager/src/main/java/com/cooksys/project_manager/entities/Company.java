package com.cooksys.project_manager.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    // added boolean deleted due to errors, not sure if needed
    private boolean isDeleted;

    @OneToMany(mappedBy = "company")
    private List<Team> teams;

    @ManyToMany(mappedBy = "companies",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    private List<User> users;

    @OneToMany(mappedBy = "company")
    private List<Announcement> announcements;
}
