package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.service.DailyLogService;
import com.healthTracker.implementation.service.MealService;
import com.healthTracker.implementation.service.UserService;
import com.healthTracker.implementation.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {

    @Autowired
    private UserService userService;

    @Autowired
    private WorkoutService workoutService;

    @Autowired
    private MealService mealService;

    @Autowired
    private DailyLogService dailyLogService;

    @GetMapping("/dashboard")
    public String adminDashboard(Model model, Principal principal) {
        List<User> allUsers = userService.getAllUsers();

        List<User> regularUsers = allUsers.stream()
                .filter(u -> "USER".equalsIgnoreCase(u.getRole()))
                .collect(Collectors.toList());

        List<User> trainers = allUsers.stream()
                .filter(u -> "TRAINER".equalsIgnoreCase(u.getRole()))
                .collect(Collectors.toList());

        model.addAttribute("users", regularUsers);
        model.addAttribute("trainers", trainers);
        model.addAttribute("adminName", principal.getName());
        return "admin-dashboard";
    }

    @PostMapping("/verify-user/{id}")
    public String verifyUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            user.setVerifiedUser(true);
            userService.updateUser(user);
        }
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/verify-trainer/{id}")
    public String verifyTrainer(@PathVariable Long id) {
        userService.verifyTrainer(id);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/stats/{id}")
    public String viewStats(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        if (user == null) {
            return "redirect:/admin/dashboard";
        }
        model.addAttribute("targetUser", user);

        // Fetch stats for the user
        model.addAttribute("workouts", workoutService.findWorkoutsByUser(user));
        model.addAttribute("meals", mealService.findMealsByUser(user));
        model.addAttribute("logs", dailyLogService.findDailyLogsByUser(user));

        return "admin-stats";
    }

    @GetMapping("/api/user-details/{id}")
    @ResponseBody
    public java.util.Map<String, Object> getUserDetails(@PathVariable Long id) {
        User user = userService.getUserById(id);
        java.util.Map<String, Object> response = new java.util.HashMap<>();
        if (user != null) {
            response.put("user", user);
            response.put("workouts", workoutService.findWorkoutsByUser(user));
            response.put("meals", mealService.findMealsByUser(user));
            response.put("logs", dailyLogService.findDailyLogsByUser(user));

            if (user.getAssignedTrainerId() != null) {
                User trainer = userService.getUserById(user.getAssignedTrainerId());
                if (trainer != null) {
                    response.put("trainerName", trainer.getFirst() + " " + trainer.getLast());
                }
            }
        }
        return response;
    }

    @PostMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/dashboard";
    }
}
