package com.cooksys.project_manager.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "company")
    private List<Team> teams;

    @OneToMany(mappedBy = "company")
    private List<User> users;

    @OneToMany(mappedBy = "company")
    private List<Announcement> announcements;
}
