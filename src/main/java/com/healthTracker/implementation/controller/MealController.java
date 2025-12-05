package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.model.Meal;
import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.service.MealService;
import com.healthTracker.implementation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String listMeals(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        List<Meal> meals = mealService.findMealsByUser(user);
        model.addAttribute("meals", meals);
        model.addAttribute("meal", new Meal());
        return "meal";
    }

    @PostMapping
    public String addMeal(@ModelAttribute Meal meal, Principal principal) {
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        meal.setUser(user);
        mealService.saveMeal(meal);
        return "redirect:/meals";
    }
}
