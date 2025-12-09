package com.healthTracker.implementation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HealthTip {
    private String title;
    private String description;
    private String category; // e.g., "Nutrition", "Exercise", "Mental Health"
}
