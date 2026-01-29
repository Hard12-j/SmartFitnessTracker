package com.healthTracker.implementation.service;

import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.model.Workout;
import com.healthTracker.implementation.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public List<Workout> findWorkoutsByUser(User user) {
        LocalDate startOfMonth = LocalDate.now().withDayOfMonth(1);
        LocalDate endOfMonth = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());

        return workoutRepository.findByUser(user).stream()
                .filter(w -> !w.getDate().isBefore(startOfMonth) && !w.getDate().isAfter(endOfMonth))
                .collect(Collectors.toList());
    }
}
