package com.healthTracker.implementation.service;

import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.model.Workout;
import com.healthTracker.implementation.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public List<Workout> findWorkoutsByUser(User user) {
        return workoutRepository.findByUser(user);
    }
}
