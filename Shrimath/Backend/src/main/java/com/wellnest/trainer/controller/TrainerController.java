package com.wellnest.trainer.controller;

import com.wellnest.trainer.dto.TrainerDTO;
import com.wellnest.trainer.dto.UserFitnessProfileDTO;
import com.wellnest.trainer.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/trainers")
@CrossOrigin(origins = "*")
public class TrainerController {
    
    @Autowired
    private TrainerService trainerService;
    
    @GetMapping
    public ResponseEntity<List<TrainerDTO>> getAllTrainers() {
        List<TrainerDTO> trainers = trainerService.getAllTrainers();
        return ResponseEntity.ok(trainers);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TrainerDTO> getTrainerById(@PathVariable Long id) {
        try {
            TrainerDTO trainer = trainerService.getTrainerById(id);
            return ResponseEntity.ok(trainer);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/match/{userName}")
    public ResponseEntity<List<TrainerDTO>> findMatchingTrainers(@PathVariable String userName) {
        try {
            List<TrainerDTO> matchedTrainers = trainerService.findMatchingTrainers(userName);
            return ResponseEntity.ok(matchedTrainers);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/profiles/{userName}")
    public ResponseEntity<UserFitnessProfileDTO> getProfile(@PathVariable String userName) {
        try {
            UserFitnessProfileDTO profile = trainerService.getProfileByUserName(userName);
            return ResponseEntity.ok(profile);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/profiles")
    public ResponseEntity<UserFitnessProfileDTO> saveOrUpdateProfile(@RequestBody UserFitnessProfileDTO profileDTO) {
        UserFitnessProfileDTO saved = trainerService.saveOrUpdateProfile(profileDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}

