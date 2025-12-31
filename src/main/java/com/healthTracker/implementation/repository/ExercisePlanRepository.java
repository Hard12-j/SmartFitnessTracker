package com.healthTracker.implementation.repository;

import com.healthTracker.implementation.model.ExercisePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExercisePlanRepository extends JpaRepository<ExercisePlan, Long> {
    List<ExercisePlan> findByUserId(Long userId);

    List<ExercisePlan> findByTrainerId(Long trainerId);

    List<ExercisePlan> findByUserIdAndDayOfWeek(Long userId, String dayOfWeek);
}
