package com.healthTracker.implementation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class DietPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long trainerId;
    private Long userId;

    private String mealName;
    private String description;
    private String dayOfWeek; // e.g., MON, TUE, etc.
    private Integer calories;
}
