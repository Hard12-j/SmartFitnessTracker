package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.model.*;
import com.healthTracker.implementation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/trainer")
public class TrainerDashboardController {

    @Autowired
    private UserService userService;

    @Autowired
    private PlanService planService;

    @Autowired
    private HealthTipService healthTipService;

    @Autowired
    private MealService mealService;

    @Autowired
    private WorkoutService workoutService;

    @Autowired
    private DailyLogService dailyLogService;

    @GetMapping("/dashboard")
    public String trainerDashboard(Model model, Principal principal) {
        if (principal == null)
            return "redirect:/login";

        User trainer = userService.getUserByUsername(principal.getName());
        List<User> assignedUsers = userService.getAllUsers().stream()
                .filter(u -> trainer.getId().equals(u.getAssignedTrainerId()))
                .collect(Collectors.toList());

        model.addAttribute("trainer", trainer);
        model.addAttribute("users", assignedUsers);
        model.addAttribute("healthTip", healthTipService.getDailyTip());
        return "trainer-dashboard";
    }

    @GetMapping("/assign-plan/{userId}")
    public String assignPlan(@PathVariable Long userId, Model model, Principal principal) {
        if (principal == null)
            return "redirect:/login";

        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        model.addAttribute("dietPlans", planService.getDietPlansForUser(userId));
        model.addAttribute("exercisePlans", planService.getExercisePlansForUser(userId));
        return "assign-plan";
    }

    @PostMapping("/assign-diet")
    public String saveDiet(@ModelAttribute DietPlan dietPlan, Principal principal) {
        User trainer = userService.getUserByUsername(principal.getName());
        dietPlan.setTrainerId(trainer.getId());
        planService.saveDietPlan(dietPlan);
        return "redirect:/trainer/assign-plan/" + dietPlan.getUserId();
    }

    @PostMapping("/assign-exercise")
    public String saveExercise(@ModelAttribute ExercisePlan exercisePlan, Principal principal) {
        User trainer = userService.getUserByUsername(principal.getName());
        exercisePlan.setTrainerId(trainer.getId());
        planService.saveExercisePlan(exercisePlan);
        return "redirect:/trainer/assign-plan/" + exercisePlan.getUserId();
    }

    @GetMapping("/analysis/{userId}")
    public String userAnalysis(@PathVariable Long userId, Model model, Principal principal) {
        if (principal == null)
            return "redirect:/login";

        User trainer = userService.getUserByUsername(principal.getName());
        User user = userService.getUserById(userId);

        // Security check
        if (user == null || !trainer.getId().equals(user.getAssignedTrainerId())) {
            return "redirect:/trainer/dashboard";
        }

        model.addAttribute("user", user);
        model.addAttribute("trainer", trainer);

        // Analysis Logic (copied from AuthController.java)
        LocalDate today = LocalDate.now();
        List<Meal> meals = mealService.findMealsByUser(user);
        List<Workout> workouts = workoutService.findWorkoutsByUser(user);
        List<DailyLog> logs = dailyLogService.findDailyLogsByUser(user);

        // Calculate Today's Summary
        int caloriesEaten = meals.stream()
                .filter(m -> m.getDate().equals(today))
                .mapToInt(Meal::getCalories)
                .sum();

        int caloriesBurned = workouts.stream()
                .filter(w -> w.getDate().equals(today))
                .mapToInt(Workout::getCalories)
                .sum();

        int steps = logs.stream()
                .filter(l -> l.getDate().equals(today))
                .mapToInt(DailyLog::getSteps)
                .sum();

        double sleep = logs.stream()
                .filter(l -> l.getDate().equals(today))
                .mapToDouble(DailyLog::getSleepDuration)
                .sum();

        model.addAttribute("caloriesEaten", caloriesEaten);
        model.addAttribute("caloriesBurned", caloriesBurned);
        model.addAttribute("steps", steps);
        model.addAttribute("sleep", sleep);

        // Calculate Weekly Summary (Last 7 days)
        List<String> datesHistory = new ArrayList<>();
        List<Integer> caloriesHistory = new ArrayList<>();
        List<Integer> stepsHistory = new ArrayList<>();

        for (int i = 6; i >= 0; i--) {
            LocalDate date = today.minusDays(i);
            datesHistory.add(date.format(DateTimeFormatter.ofPattern("MMM dd")));

            int dailyCal = meals.stream()
                    .filter(m -> m.getDate().equals(date))
                    .mapToInt(Meal::getCalories)
                    .sum();
            caloriesHistory.add(dailyCal);

            int dailySteps = logs.stream()
                    .filter(l -> l.getDate().equals(date))
                    .mapToInt(DailyLog::getSteps)
                    .sum();
            stepsHistory.add(dailySteps);
        }

        model.addAttribute("datesHistory", datesHistory);
        model.addAttribute("caloriesHistory", caloriesHistory);
        model.addAttribute("stepsHistory", stepsHistory);

        // Goal Tracking
        Integer dailyStepGoal = user.getDailyStepGoal() != null ? user.getDailyStepGoal() : 10000;
        Integer weeklyWorkoutGoal = user.getWeeklyWorkoutGoal() != null ? user.getWeeklyWorkoutGoal() : 5;

        long weeklyWorkoutsCompleted = workouts.stream()
                .filter(w -> w.getDate().isAfter(today.minusDays(7)) || w.getDate().equals(today.minusDays(7)))
                .map(Workout::getDate)
                .distinct()
                .count();

        model.addAttribute("dailyStepGoal", dailyStepGoal);
        model.addAttribute("weeklyWorkoutGoal", weeklyWorkoutGoal);
        model.addAttribute("weeklyWorkoutsCompleted", weeklyWorkoutsCompleted);

        return "user-analysis";
    }
}
