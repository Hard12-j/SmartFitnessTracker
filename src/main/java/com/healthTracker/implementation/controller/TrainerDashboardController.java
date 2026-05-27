package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.model.*;
import com.healthTracker.implementation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        @Autowired
        private TrainerRequestService trainerRequestService;

        @GetMapping("/dashboard")
        public String trainerDashboard(Model model, Principal principal) {
                if (principal == null)
                        return "redirect:/login";

                User trainer = userService.getUserByUsername(principal.getName());
                List<User> assignedUsers = userService.getAllUsers().stream()
                                .filter(u -> trainer.getId().equals(u.getAssignedTrainerId()))
                                .collect(Collectors.toList());

                List<Map<String, Object>> pendingRequests = new ArrayList<>();
                for (TrainerRequest req : trainerRequestService.getPendingRequestsForTrainer(trainer.getId())) {
                        User requester = userService.getUserById(req.getUserId());
                        if (requester != null) {
                                Map<String, Object> map = new HashMap<>();
                                map.put("id", req.getId());
                                map.put("user", requester);
                                map.put("requestedAt", req.getRequestedAt());
                                pendingRequests.add(map);
                        }
                }

                model.addAttribute("trainer", trainer);
                model.addAttribute("users", assignedUsers);
                model.addAttribute("pendingRequests", pendingRequests);
                model.addAttribute("healthTip", healthTipService.getDailyTip());
                return "trainer-dashboard";
        }

        @PostMapping("/requests/accept")
        @ResponseBody
        public ResponseEntity<?> acceptRequest(@RequestParam Long requestId, Principal principal) {
                if (principal == null) {
                        return ResponseEntity.status(401).build();
                }
                User trainer = userService.getUserByUsername(principal.getName());
                boolean success = trainerRequestService.acceptRequest(requestId, trainer.getId());
                if (success) {
                        return ResponseEntity.ok(Map.of("message", "Request accepted successfully!"));
                }
                return ResponseEntity.badRequest().body(Map.of("message", "Failed to accept request."));
        }

        @PostMapping("/requests/reject")
        @ResponseBody
        public ResponseEntity<?> rejectRequest(@RequestParam Long requestId, Principal principal) {
                if (principal == null) {
                        return ResponseEntity.status(401).build();
                }
                User trainer = userService.getUserByUsername(principal.getName());
                boolean success = trainerRequestService.rejectRequest(requestId, trainer.getId());
                if (success) {
                        return ResponseEntity.ok(Map.of("message", "Request rejected successfully."));
                }
                return ResponseEntity.badRequest().body(Map.of("message", "Failed to reject request."));
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
        public String saveDiet(
                        @ModelAttribute DietPlan dietPlan,
                        @RequestParam("userId") Long userId,
                        Principal principal,
                        org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) {
                if (principal == null) return "redirect:/login";
                try {
                        User trainer = userService.getUserByUsername(principal.getName());
                        dietPlan.setUserId(userId);
                        dietPlan.setTrainerId(trainer.getId());
                        planService.saveDietPlan(dietPlan);
                        redirectAttributes.addFlashAttribute("successMsg", "Diet entry added successfully!");
                } catch (Exception e) {
                        e.printStackTrace();
                        redirectAttributes.addFlashAttribute("errorMsg", "Failed to save diet plan: " + e.getMessage());
                }
                return "redirect:/trainer/assign-plan/" + userId;
        }

        @PostMapping("/assign-exercise")
        public String saveExercise(
                        @ModelAttribute ExercisePlan exercisePlan,
                        @RequestParam("userId") Long userId,
                        Principal principal,
                        org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) {
                if (principal == null) return "redirect:/login";
                try {
                        User trainer = userService.getUserByUsername(principal.getName());
                        exercisePlan.setUserId(userId);
                        exercisePlan.setTrainerId(trainer.getId());
                        planService.saveExercisePlan(exercisePlan);
                        redirectAttributes.addFlashAttribute("successMsg", "Exercise entry added successfully!");
                } catch (Exception e) {
                        e.printStackTrace();
                        redirectAttributes.addFlashAttribute("errorMsg", "Failed to save exercise plan: " + e.getMessage());
                }
                return "redirect:/trainer/assign-plan/" + userId;
        }

        @PostMapping("/delete-diet")
        public String deleteDiet(
                        @RequestParam("dietId") Long dietId,
                        @RequestParam("userId") Long userId,
                        org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) {
                try {
                        planService.deleteDietPlan(dietId);
                        redirectAttributes.addFlashAttribute("successMsg", "Diet entry removed.");
                } catch (Exception e) {
                        e.printStackTrace();
                        redirectAttributes.addFlashAttribute("errorMsg", "Could not remove diet entry: " + e.getMessage());
                }
                return "redirect:/trainer/assign-plan/" + userId;
        }

        @PostMapping("/delete-exercise")
        public String deleteExercise(
                        @RequestParam("exerciseId") Long exerciseId,
                        @RequestParam("userId") Long userId,
                        org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) {
                try {
                        planService.deleteExercisePlan(exerciseId);
                        redirectAttributes.addFlashAttribute("successMsg", "Exercise entry removed.");
                } catch (Exception e) {
                        e.printStackTrace();
                        redirectAttributes.addFlashAttribute("errorMsg", "Could not remove exercise entry: " + e.getMessage());
                }
                return "redirect:/trainer/assign-plan/" + userId;
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
                List<Integer> caloriesEatenHistory = new ArrayList<>();
                List<Integer> caloriesBurnedHistory = new ArrayList<>();
                List<Integer> stepsHistory = new ArrayList<>();
                List<Long> workoutFrequencyHistory = new ArrayList<>();
                List<Integer> workoutDurationHistory = new ArrayList<>();
                List<Double> waterIntakeHistory = new ArrayList<>();
                List<Double> sleepHistory = new ArrayList<>();

                java.util.Map<String, List<Integer>> workoutDataByType = new java.util.HashMap<>();

                for (int i = 6; i >= 0; i--) {
                        LocalDate date = today.minusDays(i);
                        datesHistory.add(date.format(DateTimeFormatter.ofPattern("MMM dd")));

                        int dailyCalEaten = meals.stream()
                                        .filter(m -> m.getDate().equals(date))
                                        .mapToInt(Meal::getCalories)
                                        .sum();
                        caloriesEatenHistory.add(dailyCalEaten);

                        int dailyCalBurned = workouts.stream()
                                        .filter(w -> w.getDate().equals(date))
                                        .mapToInt(Workout::getCalories)
                                        .sum();
                        caloriesBurnedHistory.add(dailyCalBurned);

                        int dailySteps = logs.stream()
                                        .filter(l -> l.getDate().equals(date))
                                        .mapToInt(DailyLog::getSteps)
                                        .sum();
                        stepsHistory.add(dailySteps);

                        // Fetch and Group Workouts by Type for this date
                        List<Workout> dailyWorkouts = workouts.stream()
                                        .filter(w -> w.getDate().equals(date))
                                        .collect(Collectors.toList());

                        // Track unique types across all days to ensure data lists are full
                        java.util.Set<String> allTypes = workouts.stream()
                                        .filter(w -> w.getDate().isAfter(today.minusDays(7))
                                                        || w.getDate().equals(today.minusDays(7)))
                                        .map(Workout::getType)
                                        .filter(java.util.Objects::nonNull)
                                        .collect(java.util.stream.Collectors.toSet());

                        for (String type : allTypes) {
                                int durationForType = dailyWorkouts.stream()
                                                .filter(w -> type.equals(w.getType()))
                                                .mapToInt(Workout::getDuration)
                                                .sum();
                                workoutDataByType.computeIfAbsent(type, k -> new ArrayList<>()).add(durationForType);
                        }

                        double dailyWater = logs.stream()
                                        .filter(l -> l.getDate().equals(date))
                                        .mapToDouble(DailyLog::getWaterIntake)
                                        .sum();
                        waterIntakeHistory.add(dailyWater);

                        double dailySleep = logs.stream()
                                        .filter(l -> l.getDate().equals(date))
                                        .mapToDouble(DailyLog::getSleepDuration)
                                        .sum();
                        sleepHistory.add(dailySleep);
                }

                model.addAttribute("datesHistory", datesHistory);
                model.addAttribute("caloriesEatenHistory", caloriesEatenHistory);
                model.addAttribute("caloriesBurnedHistory", caloriesBurnedHistory);
                model.addAttribute("stepsHistory", stepsHistory);
                model.addAttribute("workoutDataByType", workoutDataByType);
                model.addAttribute("waterIntakeHistory", waterIntakeHistory);
                model.addAttribute("sleepHistory", sleepHistory);

                // Goal Tracking
                Integer dailyStepGoal = user.getDailyStepGoal() != null ? user.getDailyStepGoal() : 10000;
                Integer weeklyWorkoutGoal = user.getWeeklyWorkoutGoal() != null ? user.getWeeklyWorkoutGoal() : 5;

                long weeklyWorkoutsCompleted = workouts.stream()
                                .filter(w -> w.getDate().isAfter(today.minusDays(7))
                                                || w.getDate().equals(today.minusDays(7)))
                                .map(Workout::getDate)
                                .distinct()
                                .count();

                model.addAttribute("dailyStepGoal", dailyStepGoal);
                model.addAttribute("weeklyWorkoutGoal", weeklyWorkoutGoal);
                model.addAttribute("weeklyWorkoutsCompleted", weeklyWorkoutsCompleted);

                return "user-analysis";
        }
}
