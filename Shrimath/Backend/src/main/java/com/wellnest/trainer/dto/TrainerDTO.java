package com.wellnest.trainer.dto;

import java.util.List;

public class TrainerDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Integer experienceYears;
    private Double rating;
    private String profileSummary;
    private String location;
    private List<String> specializations;
    private List<AvailabilityDTO> availability;
    private Integer matchScore;

    public TrainerDTO() {
    }

    public TrainerDTO(Long id, String name, String email, String phone, Integer experienceYears, Double rating,
                      String profileSummary, String location, List<String> specializations, List<AvailabilityDTO> availability,
                      Integer matchScore) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.experienceYears = experienceYears;
        this.rating = rating;
        this.profileSummary = profileSummary;
        this.location = location;
        this.specializations = specializations;
        this.availability = availability;
        this.matchScore = matchScore;
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

    public List<String> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<String> specializations) {
        this.specializations = specializations;
    }

    public List<AvailabilityDTO> getAvailability() {
        return availability;
    }

    public void setAvailability(List<AvailabilityDTO> availability) {
        this.availability = availability;
    }

    public Integer getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(Integer matchScore) {
        this.matchScore = matchScore;
    }

    @Override
    public String toString() {
        return "TrainerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", experienceYears=" + experienceYears +
                ", rating=" + rating +
                ", profileSummary='" + profileSummary + '\'' +
                ", location='" + location + '\'' +
                ", matchScore=" + matchScore +
                '}';
    }
}
