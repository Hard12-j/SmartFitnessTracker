package com.wellnest.trainer.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trainers")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String email;

    private String phone;

    @Column(nullable = false)
    private Integer experienceYears = 0;

    @Column(columnDefinition = "DECIMAL(3,2) DEFAULT 0.00")
    private Double rating = 0.0;

    @Column(columnDefinition = "TEXT")
    private String profileSummary;

    private String location;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrainerSpecialization> specializations = new ArrayList<>();

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrainerAvailability> availability = new ArrayList<>();

    public Trainer() {
    }

    public Trainer(Long id, String name, String email, String phone, Integer experienceYears, Double rating,
            String profileSummary, String location, LocalDateTime createdAt, LocalDateTime updatedAt,
            List<TrainerSpecialization> specializations, List<TrainerAvailability> availability) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.experienceYears = experienceYears;
        this.rating = rating;
        this.profileSummary = profileSummary;
        this.location = location;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.specializations = specializations;
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getProfileSummary() {
        return profileSummary;
    }

    public void setProfileSummary(String profileSummary) {
        this.profileSummary = profileSummary;
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

    public List<TrainerSpecialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<TrainerSpecialization> specializations) {
        this.specializations = specializations;
    }

    public List<TrainerAvailability> getAvailability() {
        return availability;
    }

    public void setAvailability(List<TrainerAvailability> availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", experienceYears=" + experienceYears +
                ", rating=" + rating +
                ", profileSummary='" + profileSummary + '\'' +
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
