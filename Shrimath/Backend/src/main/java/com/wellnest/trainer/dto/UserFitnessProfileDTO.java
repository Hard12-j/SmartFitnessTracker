package com.wellnest.trainer.dto;

public class UserFitnessProfileDTO {
    private Long id;
    private String userName;
    private String fitnessGoal;
    private String preferredWorkoutType;
    private Integer age;
    private String experienceLevel;
    private String preferredTrainingStyle;
    private String location;

    public UserFitnessProfileDTO() {
    }

    public UserFitnessProfileDTO(Long id, String userName, String fitnessGoal, String preferredWorkoutType, Integer age,
                                 String experienceLevel, String preferredTrainingStyle, String location) {
        this.id = id;
        this.userName = userName;
        this.fitnessGoal = fitnessGoal;
        this.preferredWorkoutType = preferredWorkoutType;
        this.age = age;
        this.experienceLevel = experienceLevel;
        this.preferredTrainingStyle = preferredTrainingStyle;
        this.location = location;
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

    @Override
    public String toString() {
        return "UserFitnessProfileDTO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", fitnessGoal='" + fitnessGoal + '\'' +
                ", preferredWorkoutType='" + preferredWorkoutType + '\'' +
                ", age=" + age +
                ", experienceLevel='" + experienceLevel + '\'' +
                ", preferredTrainingStyle='" + preferredTrainingStyle + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
