package com.wellnest.trainer.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_fitness_profiles")
public class UserFitnessProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    private String fitnessGoal; // WEIGHT_LOSS, MUSCLE_GAIN, GENERAL_FITNESS, etc.

    private String preferredWorkoutType; // CARDIO, STRENGTH, YOGA, etc.

    private Integer age;

    private String experienceLevel; // BEGINNER, INTERMEDIATE, ADVANCED

    private String preferredTrainingStyle;

    private String location;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public UserFitnessProfile() {
    }

    public UserFitnessProfile(Long id, String userName, String fitnessGoal, String preferredWorkoutType, Integer age,
            String experienceLevel, String preferredTrainingStyle, String location, LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.userName = userName;
        this.fitnessGoal = fitnessGoal;
        this.preferredWorkoutType = preferredWorkoutType;
        this.age = age;
        this.experienceLevel = experienceLevel;
        this.preferredTrainingStyle = preferredTrainingStyle;
        this.location = location;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFitnessGoal() {
        return fitnessGoal;
    }

    public void setFitnessGoal(String fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }

    public String getPreferredWorkoutType() {
        return preferredWorkoutType;
    }

    public void setPreferredWorkoutType(String preferredWorkoutType) {
        this.preferredWorkoutType = preferredWorkoutType;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public String getPreferredTrainingStyle() {
        return preferredTrainingStyle;
    }

    public void setPreferredTrainingStyle(String preferredTrainingStyle) {
        this.preferredTrainingStyle = preferredTrainingStyle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "UserFitnessProfile{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", fitnessGoal='" + fitnessGoal + '\'' +
                ", preferredWorkoutType='" + preferredWorkoutType + '\'' +
                ", age=" + age +
                ", experienceLevel='" + experienceLevel + '\'' +
                ", preferredTrainingStyle='" + preferredTrainingStyle + '\'' +
                ", location='" + location + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
