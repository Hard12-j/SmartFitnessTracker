package com.healthTracker.implementation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // Breakfast, Lunch, Dinner, Snack
    private int calories;
    private double protein;
    private double carbs;
    private double fats;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
