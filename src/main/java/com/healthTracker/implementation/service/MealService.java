package com.healthTracker.implementation.service;

import com.healthTracker.implementation.model.Meal;
import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public Meal saveMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public List<Meal> findMealsByUser(User user) {
        LocalDate startOfMonth = LocalDate.now().withDayOfMonth(1);
        LocalDate endOfMonth = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());

        return mealRepository.findByUser(user).stream()
                .filter(m -> !m.getDate().isBefore(startOfMonth) && !m.getDate().isAfter(endOfMonth))
                .collect(Collectors.toList());
    }
}
