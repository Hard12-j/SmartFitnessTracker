package com.healthTracker.implementation.service;

import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllTrainers() {
        return userRepository.findAll().stream()
                .filter(user -> "TRAINER".equalsIgnoreCase(user.getRole()))
                .collect(Collectors.toList());
    }

    public List<User> getRecommendedTrainers(String userGoal) {
        List<User> trainers = getAllTrainers();
        if (userGoal == null || userGoal.isEmpty()) {
            return trainers;
        }

        // Simple matching logic: case-insensitive check if user goal is in trainer's
        // specialization
        return trainers.stream()
                .filter(trainer -> trainer.getSpecialization() != null &&
                        (trainer.getSpecialization().toLowerCase().contains(userGoal.toLowerCase()) ||
                                userGoal.toLowerCase().contains(trainer.getSpecialization().toLowerCase())))
                .collect(Collectors.toList());
    }
}
