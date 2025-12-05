package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.model.Workout;
import com.healthTracker.implementation.service.UserService;
import com.healthTracker.implementation.service.WorkoutService;
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
@RequestMapping("/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String listWorkouts(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        List<Workout> workouts = workoutService.findWorkoutsByUser(user);
        model.addAttribute("workouts", workouts);
        model.addAttribute("workout", new Workout());
        return "workout";
    }

    @PostMapping
    public String addWorkout(@ModelAttribute Workout workout, Principal principal) {
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        workout.setUser(user);
        workoutService.saveWorkout(workout);
        return "redirect:/workouts";
    }
}
