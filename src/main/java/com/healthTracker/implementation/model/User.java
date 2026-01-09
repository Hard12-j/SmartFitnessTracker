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

    private Integer dailyStepGoal = 10000;
    private Integer weeklyWorkoutGoal = 5;
    private Double weightGoal;
    private Double waterIntakeGoal = 3.0;

    // Trainer specific fields
    private String specialization;
    private String trainerLocation;
    private String availability;
    private String experience;
    private String contactNo;
    private boolean isVerifiedTrainer = false;
    private String profileImageUrl;
    private Long assignedTrainerId;
}
