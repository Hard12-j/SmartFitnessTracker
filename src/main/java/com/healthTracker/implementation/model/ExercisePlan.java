package com.healthTracker.implementation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class ExercisePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long trainerId;
    private Long userId;

    private String exerciseName;
    private Integer sets;
    private Integer reps;
    private String description;
    private String dayOfWeek;
}
