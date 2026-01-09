package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.dto.UserDto;
import com.healthTracker.implementation.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.healthTracker.implementation.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") UserDto userDto,
            org.springframework.validation.BindingResult result,
            Model model,
            org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) {
        System.out.println(userDto.getPassword().equals(userDto.getCnfPassword()));

        if (result.hasErrors()) {
            return "register";
        }

        if (!userDto.getPassword().equals(userDto.getCnfPassword())) {
            model.addAttribute("error", "Passwords do not match!");
            return "register";
        }

        try {
            User user = new User();
            user.setFirst(userDto.getFirst());
            user.setLast(userDto.getLast());
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            user.setRole(userDto.getRole());

            userService.registerUser(user);
            System.out.println("successfully registered");
            redirectAttributes.addFlashAttribute("success", "User registered successfully!");
            return "redirect:/login";
        } catch (Exception e) {
            System.out.println("Passwords do not match!");
            model.addAttribute("error", "Registration failed: " + e.getMessage());
            return "register";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @Autowired
    private com.healthTracker.implementation.service.HealthTipService healthTipService;

    @Autowired
    private com.healthTracker.implementation.service.DailyLogService dailyLogService;
    @Autowired
    private com.healthTracker.implementation.service.WorkoutService workoutService;
    @Autowired
    private com.healthTracker.implementation.service.MealService mealService;
    @Autowired
    private com.healthTracker.implementation.service.PlanService planService;

    @GetMapping("/welcome")
    public String welcome(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        User user = userService.getUserByUsername(principal.getName());

        if ("TRAINER".equalsIgnoreCase(user.getRole())) {
            return "redirect:/trainer/dashboard";
        }

        // Today's Date
        java.time.LocalDate today = java.time.LocalDate.now();

        // Fetch Data
        List<com.healthTracker.implementation.model.Meal> meals = mealService.findMealsByUser(user);
        List<com.healthTracker.implementation.model.Workout> workouts = workoutService.findWorkoutsByUser(user);
        List<com.healthTracker.implementation.model.DailyLog> logs = dailyLogService.findDailyLogsByUser(user);

        // Calculate Today's Summary
        int caloriesEaten = meals.stream()
                .filter(m -> m.getDate().equals(today))
                .mapToInt(com.healthTracker.implementation.model.Meal::getCalories)
                .sum();

        int caloriesBurned = workouts.stream()
                .filter(w -> w.getDate().equals(today))
                .mapToInt(com.healthTracker.implementation.model.Workout::getCalories)
                .sum();

        int steps = logs.stream()
                .filter(l -> l.getDate().equals(today))
                .mapToInt(com.healthTracker.implementation.model.DailyLog::getSteps)
                .sum();

        double sleep = logs.stream()
                .filter(l -> l.getDate().equals(today))
                .mapToDouble(com.healthTracker.implementation.model.DailyLog::getSleepDuration)
                .sum();

        model.addAttribute("caloriesEaten", caloriesEaten);
        model.addAttribute("caloriesBurned", caloriesBurned);
        model.addAttribute("steps", steps);
        model.addAttribute("sleep", sleep);

        // Calculate Weekly Summary (Last 7 days)
        java.util.List<String> datesHistory = new java.util.ArrayList<>();
        java.util.List<Integer> caloriesEatenHistory = new java.util.ArrayList<>();
        java.util.List<Integer> caloriesBurnedHistory = new java.util.ArrayList<>();
        java.util.List<Integer> stepsHistory = new java.util.ArrayList<>();
        java.util.List<Long> workoutFrequencyHistory = new java.util.ArrayList<>();
        java.util.List<Integer> workoutDurationHistory = new java.util.ArrayList<>();
        java.util.List<Double> waterIntakeHistory = new java.util.ArrayList<>();
        java.util.List<Double> sleepHistory = new java.util.ArrayList<>();

        for (int i = 6; i >= 0; i--) {
            java.time.LocalDate date = today.minusDays(i);
            datesHistory.add(date.format(java.time.format.DateTimeFormatter.ofPattern("MMM dd")));

            int dailyCalEaten = meals.stream()
                    .filter(m -> m.getDate().equals(date))
                    .mapToInt(com.healthTracker.implementation.model.Meal::getCalories)
                    .sum();
            caloriesEatenHistory.add(dailyCalEaten);

            int dailyCalBurned = workouts.stream()
                    .filter(w -> w.getDate().equals(date))
                    .mapToInt(com.healthTracker.implementation.model.Workout::getCalories)
                    .sum();
            caloriesBurnedHistory.add(dailyCalBurned);

            int dailySteps = logs.stream()
                    .filter(l -> l.getDate().equals(date))
                    .mapToInt(com.healthTracker.implementation.model.DailyLog::getSteps)
                    .sum();
            stepsHistory.add(dailySteps);

            long frequency = workouts.stream()
                    .filter(w -> w.getDate().equals(date))
                    .count();
            workoutFrequencyHistory.add(frequency);

            int dailyDuration = workouts.stream()
                    .filter(w -> w.getDate().equals(date))
                    .mapToInt(com.healthTracker.implementation.model.Workout::getDuration)
                    .sum();
            workoutDurationHistory.add(dailyDuration);

            double dailyWater = logs.stream()
                    .filter(l -> l.getDate().equals(date))
                    .mapToDouble(com.healthTracker.implementation.model.DailyLog::getWaterIntake)
                    .sum();
            waterIntakeHistory.add(dailyWater);

            double dailySleep = logs.stream()
                    .filter(l -> l.getDate().equals(date))
                    .mapToDouble(com.healthTracker.implementation.model.DailyLog::getSleepDuration)
                    .sum();
            sleepHistory.add(dailySleep);
        }

        model.addAttribute("datesHistory", datesHistory);
        model.addAttribute("caloriesEatenHistory", caloriesEatenHistory);
        model.addAttribute("caloriesBurnedHistory", caloriesBurnedHistory);
        model.addAttribute("stepsHistory", stepsHistory);
        model.addAttribute("workoutFrequencyHistory", workoutFrequencyHistory);
        model.addAttribute("workoutDurationHistory", workoutDurationHistory);
        model.addAttribute("waterIntakeHistory", waterIntakeHistory);
        model.addAttribute("sleepHistory", sleepHistory);

        // Goal Tracking
        Integer dailyStepGoal = user.getDailyStepGoal() != null ? user.getDailyStepGoal() : 10000;
        Integer weeklyWorkoutGoal = user.getWeeklyWorkoutGoal() != null ? user.getWeeklyWorkoutGoal() : 5;

        // Calculate Workouts in Last 7 Days (Unique Days)
        long weeklyWorkoutsCompleted = workouts.stream()
                .filter(w -> w.getDate().isAfter(today.minusDays(7)) || w.getDate().equals(today.minusDays(7)))
                .map(com.healthTracker.implementation.model.Workout::getDate)
                .distinct()
                .count();

        model.addAttribute("dailyStepGoal", dailyStepGoal);
        model.addAttribute("weeklyWorkoutGoal", weeklyWorkoutGoal);
        model.addAttribute("weeklyWorkoutsCompleted", weeklyWorkoutsCompleted);

        // Assigned Plans
        model.addAttribute("assignedDiet", planService.getDietPlansForUser(user.getId()));
        model.addAttribute("assignedExercises", planService.getExercisePlansForUser(user.getId()));

        model.addAttribute("healthTip", healthTipService.getDailyTip());
        return "welcome";
    }

    @GetMapping("profile")
    public String profile() {
        return "profile";
    }

    @PostMapping("/update-profile")
    public String updateProfile(@ModelAttribute User user,
            @org.springframework.web.bind.annotation.RequestParam("profileImage") org.springframework.web.multipart.MultipartFile profileImage) {
        if (profileImage != null && !profileImage.isEmpty()) {
            try {
                String fileName = user.getId() + "_" + profileImage.getOriginalFilename();
                java.nio.file.Path uploadPath = java.nio.file.Paths.get("uploads/profile_images");
                if (!java.nio.file.Files.exists(uploadPath)) {
                    java.nio.file.Files.createDirectories(uploadPath);
                }

                try (java.io.InputStream inputStream = profileImage.getInputStream()) {
                    java.nio.file.Path filePath = uploadPath.resolve(fileName);
                    java.nio.file.Files.copy(inputStream, filePath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                    user.setProfileImageUrl("/uploads/profile_images/" + fileName);
                }
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
        userService.updateUserProfile(user);
        return "redirect:/profile";
    }

    @PostMapping("/update-goals")
    public String updateGoals(@ModelAttribute User user) {
        // We reuse updateUserProfile as it only updates non-null fields
        userService.updateUserProfile(user);
        return "redirect:/welcome";
    }

    @Autowired
    private com.healthTracker.implementation.service.EmailService emailService;

    @GetMapping("/forgot-password")
    public String showForgotPasswordForm() {
        return "forgot_password";
    }

    @PostMapping("/forgot-password")
    public String processForgotPassword(jakarta.servlet.http.HttpServletRequest request, Model model,
            @org.springframework.web.bind.annotation.RequestParam("email") String userEmail,
            org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) {
        User user = userService.getUserByUsername(userEmail);
        if (user == null) {
            model.addAttribute("error", "We didn't find an account for that e-mail address.");
            return "forgot_password";
        }

        try {
            String otp = userService.createPasswordResetTokenForUser(user);

            emailService.sendEmail(user.getUsername(), "Reset Password OTP",
                    "Your One-Time Password (OTP) for password reset is: " + otp + "\nThis OTP is valid for 1 hour.");
            redirectAttributes.addFlashAttribute("message",
                    "We have sent an OTP to your email. Please enter it below.");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Error processing request: " + e.getMessage());
            return "forgot_password";
        }

        return "redirect:/verify-otp";
    }

    @GetMapping("/verify-otp")
    public String showVerifyOtpForm() {
        return "verify_otp";
    }

    @PostMapping("/verify-otp")
    public String verifyOtp(@org.springframework.web.bind.annotation.RequestParam("otp") String otp, Model model,
            org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) {
        String validationResult = userService.validatePasswordResetToken(otp);
        if (validationResult != null) {
            model.addAttribute("error", "Invalid or expired OTP.");
            return "verify_otp";
        }
        return "redirect:/reset-password?token=" + otp;
    }

    @GetMapping("/reset-password")
    public String showResetPasswordForm(@org.springframework.web.bind.annotation.RequestParam("token") String token,
            Model model) {
        String result = userService.validatePasswordResetToken(token);
        if (result != null) {
            model.addAttribute("error", "Invalid or expired token. Please request a new password reset.");
            return "reset_password"; // Show error on the page instead of redirecting to login
        }
        com.healthTracker.implementation.dto.PasswordResetDto passwordResetDto = new com.healthTracker.implementation.dto.PasswordResetDto();
        passwordResetDto.setToken(token);
        model.addAttribute("passwordResetDto", passwordResetDto);
        return "reset_password";
    }

    @PostMapping("/reset-password")
    public String processResetPassword(
            @Valid @ModelAttribute("passwordResetDto") com.healthTracker.implementation.dto.PasswordResetDto passwordResetDto,
            org.springframework.validation.BindingResult result,
            Model model,
            org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "reset_password";
        }

        if (!passwordResetDto.getPassword().equals(passwordResetDto.getConfirmPassword())) {
            model.addAttribute("error", "Passwords do not match!");
            return "reset_password";
        }

        String token = passwordResetDto.getToken();
        String validationResult = userService.validatePasswordResetToken(token);
        if (validationResult != null) {
            model.addAttribute("error", "Invalid or expired token.");
            return "redirect:/login";
        }

        User user = userService.getUserByPasswordResetToken(token);
        if (user != null) {
            userService.changeUserPassword(user, passwordResetDto.getPassword());
            redirectAttributes.addFlashAttribute("success", "Password reset successfully! You can now login.");
            return "redirect:/login";
        } else {
            model.addAttribute("error", "User not found.");
            return "reset_password";
        }
    }
}
