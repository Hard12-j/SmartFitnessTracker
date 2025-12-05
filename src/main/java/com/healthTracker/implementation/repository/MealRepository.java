package com.healthTracker.implementation.repository;

import com.healthTracker.implementation.model.Meal;
import com.healthTracker.implementation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findByUser(User user);
}
