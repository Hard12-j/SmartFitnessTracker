package com.healthTracker.implementation.controller;

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

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user,
            Model model) {
        System.out.println(user.getPassword().equals(user.getCnfPassword()));

        if (!user.getPassword().equals(user.getCnfPassword())) {
            model.addAttribute("error", "Passwords do not match!");
            return "register";
        }

        try {
            userService.registerUser(user);
            System.out.println("successfully registered");
            model.addAttribute("success", "User registered successfully!");
            return "redirect:/login";
        } catch (Exception e) {
            System.out.println("Passwords do not match!");
            model.addAttribute("error", "Registration failed: " + e.getMessage());
            return "register";
        }
    }

    @ModelAttribute
    public void getUserDtls(Principal p, Model model) {
        if (p != null) {
            String username = p.getName();
            User userDtls = userService.getUserByUsername(username);
            model.addAttribute("user", userDtls);
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @Autowired
    private com.healthTracker.implementation.service.HealthTipService healthTipService;

    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("healthTip", healthTipService.getDailyTip());
        return "welcome";
    }

    @GetMapping("profile")
    public String profile() {
        return "profile";
    }

    @PostMapping("/update-profile")
    public String updateProfile(@ModelAttribute User user) {
        userService.updateUserProfile(user);
        return "redirect:/profile";
    }
}
