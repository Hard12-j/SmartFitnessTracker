package com.healthTracker.implementation.service;

import com.healthTracker.implementation.model.Meal;
import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public Meal saveMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public List<Meal> findMealsByUser(User user) {
        return mealRepository.findByUser(user);
    }
}
