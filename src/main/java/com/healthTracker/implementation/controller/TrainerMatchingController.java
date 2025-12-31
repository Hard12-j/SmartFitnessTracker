package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.service.TrainerService;
import com.healthTracker.implementation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class TrainerMatchingController {

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private UserService userService;

    @GetMapping("/trainer-matching")
    public String showTrainerMatching(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        User user = userService.getUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "trainer-matching";
    }

    @GetMapping("/api/trainers/match")
    @ResponseBody
    public ResponseEntity<List<User>> matchTrainers(Principal principal, @RequestParam(required = false) String goal) {
        if (principal == null) {
            return ResponseEntity.status(401).build();
        }

        String userGoal = goal;
        if (userGoal == null || userGoal.isEmpty()) {
            User user = userService.getUserByUsername(principal.getName());
            userGoal = user.getGoals();
        }

        List<User> recommended = trainerService.getRecommendedTrainers(userGoal);
        return ResponseEntity.ok(recommended);
    }

    @PostMapping("/api/trainers/book")
    @ResponseBody
    public ResponseEntity<?> bookTrainer(Principal principal, @RequestParam Long trainerId) {
        if (principal == null) {
            return ResponseEntity.status(401).build();
        }

        User user = userService.getUserByUsername(principal.getName());
        user.setAssignedTrainerId(trainerId);
        userService.updateUserProfile(user);

        return ResponseEntity.ok().body(Map.of("message", "Trainer booked successfully!"));
    }
}
