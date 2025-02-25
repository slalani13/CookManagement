package com.cooksys.project_manager.entities;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Credentials credentials;

    @Embedded
    private Profile profile;

    private boolean isActive;

    private boolean isAdmin;

    private String status;

    @OneToMany(mappedBy = "author",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Announcement> announcements;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @ManyToMany(mappedBy = "users")
    private List<Team> teams;



}
