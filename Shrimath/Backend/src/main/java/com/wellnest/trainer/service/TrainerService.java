package com.wellnest.trainer.service;

import com.wellnest.trainer.dto.AvailabilityDTO;
import com.wellnest.trainer.dto.TrainerDTO;
import com.wellnest.trainer.dto.UserFitnessProfileDTO;
import com.wellnest.trainer.entity.Trainer;
import com.wellnest.trainer.entity.TrainerAvailability;
import com.wellnest.trainer.entity.TrainerSpecialization;
import com.wellnest.trainer.entity.UserFitnessProfile;
import com.wellnest.trainer.repository.TrainerRepository;
import com.wellnest.trainer.repository.TrainerSpecializationRepository;
import com.wellnest.trainer.repository.UserFitnessProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class TrainerService {
    
    @Autowired
    private TrainerRepository trainerRepository;
    
    @Autowired
    private TrainerSpecializationRepository specializationRepository;
    
    @Autowired
    private UserFitnessProfileRepository profileRepository;
    
    public List<TrainerDTO> getAllTrainers() {
        return trainerRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public TrainerDTO getTrainerById(Long id) {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found with id: " + id));
        return convertToDTO(trainer);
    }
    
    public List<TrainerDTO> findMatchingTrainers(String userName) {
        UserFitnessProfile profile = profileRepository.findByUserName(userName)
                .orElseThrow(() -> new RuntimeException("User fitness profile not found for: " + userName));
        
        List<Trainer> allTrainers = trainerRepository.findAll();
        List<TrainerDTO> matchedTrainers = new ArrayList<>();
        
        for (Trainer trainer : allTrainers) {
            int matchScore = calculateMatchScore(trainer, profile);
            if (matchScore > 0) {
                TrainerDTO dto = convertToDTO(trainer);
                dto.setMatchScore(matchScore);
                matchedTrainers.add(dto);
            }
        }
        
        // Sort by match score descending
        matchedTrainers.sort((a, b) -> Integer.compare(b.getMatchScore(), a.getMatchScore()));
        
        return matchedTrainers;
    }
    
    private int calculateMatchScore(Trainer trainer, UserFitnessProfile profile) {
        int score = 0;
        
        // Goal-to-Specialization match (highest weight: 50 points)
        if (profile.getFitnessGoal() != null && !profile.getFitnessGoal().isEmpty()) {
            List<String> trainerSpecs = trainer.getSpecializations().stream()
                    .map(TrainerSpecialization::getSpecialization)
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
            
            String userGoal = profile.getFitnessGoal().toUpperCase();
            
            // Direct match
            if (trainerSpecs.contains(userGoal)) {
                score += 50;
            }
            // Related matches
            else if (userGoal.contains("WEIGHT") || userGoal.contains("LOSS")) {
                if (trainerSpecs.contains("WEIGHT_LOSS") || trainerSpecs.contains("CARDIO") || 
                    trainerSpecs.contains("HIIT") || trainerSpecs.contains("NUTRITION")) {
                    score += 40;
                }
            } else if (userGoal.contains("MUSCLE") || userGoal.contains("GAIN")) {
                if (trainerSpecs.contains("MUSCLE_GAIN") || trainerSpecs.contains("STRENGTH") || 
                    trainerSpecs.contains("BODYBUILDING")) {
                    score += 40;
                }
            } else if (userGoal.contains("FITNESS") || userGoal.contains("GENERAL")) {
                if (trainerSpecs.contains("GENERAL_FITNESS") || trainerSpecs.contains("FUNCTIONAL_TRAINING")) {
                    score += 40;
                }
            }
        }
        
        // Workout preference match (30 points)
        if (profile.getPreferredWorkoutType() != null && !profile.getPreferredWorkoutType().isEmpty()) {
            List<String> trainerSpecs = trainer.getSpecializations().stream()
                    .map(TrainerSpecialization::getSpecialization)
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
            
            String workoutType = profile.getPreferredWorkoutType().toUpperCase();
            if (trainerSpecs.contains(workoutType) || 
                trainerSpecs.stream().anyMatch(spec -> spec.contains(workoutType))) {
                score += 30;
            }
        }
        
        // Experience level match (10 points)
        if (profile.getExperienceLevel() != null && !profile.getExperienceLevel().isEmpty()) {
            String level = profile.getExperienceLevel().toUpperCase();
            if (level.equals("BEGINNER") && trainer.getExperienceYears() >= 3) {
                score += 10;
            } else if (level.equals("INTERMEDIATE") && trainer.getExperienceYears() >= 5) {
                score += 10;
            } else if (level.equals("ADVANCED") && trainer.getExperienceYears() >= 8) {
                score += 10;
            }
        }
        
        // Location match (10 points)
        if (profile.getLocation() != null && trainer.getLocation() != null) {
            if (profile.getLocation().equalsIgnoreCase(trainer.getLocation())) {
                score += 10;
            }
        }
        
        // Rating bonus (up to 5 points)
        if (trainer.getRating() != null && trainer.getRating() >= 4.5) {
            score += 5;
        }
        
        return score;
    }
    
    public UserFitnessProfileDTO saveOrUpdateProfile(UserFitnessProfileDTO profileDTO) {
        UserFitnessProfile profile = profileRepository.findByUserName(profileDTO.getUserName())
                .orElse(new UserFitnessProfile());
        
        profile.setUserName(profileDTO.getUserName());
        profile.setFitnessGoal(profileDTO.getFitnessGoal());
        profile.setPreferredWorkoutType(profileDTO.getPreferredWorkoutType());
        profile.setAge(profileDTO.getAge());
        profile.setExperienceLevel(profileDTO.getExperienceLevel());
        profile.setPreferredTrainingStyle(profileDTO.getPreferredTrainingStyle());
        profile.setLocation(profileDTO.getLocation());
        
        UserFitnessProfile saved = profileRepository.save(profile);
        return convertProfileToDTO(saved);
    }
    
    public UserFitnessProfileDTO getProfileByUserName(String userName) {
        UserFitnessProfile profile = profileRepository.findByUserName(userName)
                .orElseThrow(() -> new RuntimeException("Profile not found for: " + userName));
        return convertProfileToDTO(profile);
    }
    
    private TrainerDTO convertToDTO(Trainer trainer) {
        TrainerDTO dto = new TrainerDTO();
        dto.setId(trainer.getId());
        dto.setName(trainer.getName());
        dto.setEmail(trainer.getEmail());
        dto.setPhone(trainer.getPhone());
        dto.setExperienceYears(trainer.getExperienceYears());
        dto.setRating(trainer.getRating());
        dto.setProfileSummary(trainer.getProfileSummary());
        dto.setLocation(trainer.getLocation());
        
        dto.setSpecializations(trainer.getSpecializations().stream()
                .map(TrainerSpecialization::getSpecialization)
                .collect(Collectors.toList()));
        
        dto.setAvailability(trainer.getAvailability().stream()
                .map(av -> new AvailabilityDTO(av.getDayOfWeek(), av.getStartTime(), av.getEndTime()))
                .collect(Collectors.toList()));
        
        return dto;
    }
    
    private UserFitnessProfileDTO convertProfileToDTO(UserFitnessProfile profile) {
        UserFitnessProfileDTO dto = new UserFitnessProfileDTO();
        dto.setId(profile.getId());
        dto.setUserName(profile.getUserName());
        dto.setFitnessGoal(profile.getFitnessGoal());
        dto.setPreferredWorkoutType(profile.getPreferredWorkoutType());
        dto.setAge(profile.getAge());
        dto.setExperienceLevel(profile.getExperienceLevel());
        dto.setPreferredTrainingStyle(profile.getPreferredTrainingStyle());
        dto.setLocation(profile.getLocation());
        return dto;
    }
}

