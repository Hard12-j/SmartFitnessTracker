package com.healthTracker.implementation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String first;
    private String last;
    private String username;
    private String password;
    private String role;
    @Transient
    private String cnfPassword;

    private String age;
    private String weight;
    private String height;
    private String goals;
}
