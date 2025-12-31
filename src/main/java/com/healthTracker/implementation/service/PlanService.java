package com.healthTracker.implementation.service;

import com.healthTracker.implementation.model.DietPlan;
import com.healthTracker.implementation.model.ExercisePlan;
import com.healthTracker.implementation.repository.DietPlanRepository;
import com.healthTracker.implementation.repository.ExercisePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    @Autowired
    private DietPlanRepository dietPlanRepository;

    @Autowired
    private ExercisePlanRepository exercisePlanRepository;

    public DietPlan saveDietPlan(DietPlan dietPlan) {
        return dietPlanRepository.save(dietPlan);
    }

    public ExercisePlan saveExercisePlan(ExercisePlan exercisePlan) {
        return exercisePlanRepository.save(exercisePlan);
    }

    public List<DietPlan> getDietPlansForUser(Long userId) {
        return dietPlanRepository.findByUserId(userId);
    }

    public List<ExercisePlan> getExercisePlansForUser(Long userId) {
        return exercisePlanRepository.findByUserId(userId);
    }

    public List<DietPlan> getDietPlansForTrainer(Long trainerId) {
        return dietPlanRepository.findByTrainerId(trainerId);
    }

    public List<ExercisePlan> getExercisePlansForTrainer(Long trainerId) {
        return exercisePlanRepository.findByTrainerId(trainerId);
    }

    public void deleteDietPlan(Long id) {
        dietPlanRepository.deleteById(id);
    }

    public void deleteExercisePlan(Long id) {
        exercisePlanRepository.deleteById(id);
    }
}
