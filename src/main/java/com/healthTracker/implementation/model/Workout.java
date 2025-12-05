package com.healthTracker.implementation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "workout")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private int duration; // in minutes
    private int calories;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
