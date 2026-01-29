package com.healthTracker.implementation.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String first;
    private String last;
    private String username;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@_]).{9,}$", message = "Password length must be > 8, contain 1 uppercase, 1 lowercase, 1 number, and 1 special character (@ or _)")
    private String password;

    private String cnfPassword;
    private String role;

    // Trainer specific fields
    private String specialization;
    private String experience;
    private String trainerLocation;
    private String availability;
    private String contactNo;
}
