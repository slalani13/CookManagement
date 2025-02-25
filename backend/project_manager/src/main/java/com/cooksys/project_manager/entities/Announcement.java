package com.cooksys.project_manager.entities;

import jakarta.persistence.*;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Announcement {
    @Id
    @GeneratedValue
    private Long id;

    private Timestamp date;

    private String title;

    private String message;

//    private boolean deleted;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

}
