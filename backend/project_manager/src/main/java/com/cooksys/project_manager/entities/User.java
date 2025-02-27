package com.cooksys.project_manager.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


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

    // deleted or not deleted
    private boolean isActive;

    private boolean isAdmin;

    // logged in = 'active', logged out = 'inactive'
    private String status;

    @OneToMany(mappedBy = "author",
            cascade = CascadeType.ALL)
    private List<Announcement> announcements;

    @ManyToMany
    @JoinTable(
            name = "user_company",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private List<Company> companies;

    @ManyToMany(mappedBy = "users")
    private List<Team> teams;



}
