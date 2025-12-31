package com.healthTracker.implementation.repository;

import com.healthTracker.implementation.model.DietPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DietPlanRepository extends JpaRepository<DietPlan, Long> {
    List<DietPlan> findByUserId(Long userId);

    List<DietPlan> findByTrainerId(Long trainerId);

    List<DietPlan> findByUserIdAndDayOfWeek(Long userId, String dayOfWeek);
}
