package com.healthTracker.implementation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BmiController {

    @GetMapping("/bmi")
    public String bmiPage() {
        return "bmi_calculator";
    }

    @PostMapping("/calculate-bmi")
    public String calculateBmi(@RequestParam("height") Double height,
            @RequestParam("weight") Double weight,
            Model model) {
        if (height == null || weight == null || height <= 0 || weight <= 0) {
            model.addAttribute("error", "Please enter valid height and weight values.");
            return "bmi_calculator";
        }

        double bmi = weight / ((height / 100) * (height / 100));
        String bmiValue = String.format("%.2f", bmi);

        String status;
        String guidance;
        String colorClass;

        if (bmi < 18.5) {
            status = "Underweight";
            guidance = "Focus on nutrient-rich foods and strength training to build muscle mass.";
            colorClass = "text-orange";
        } else if (bmi < 24.9) {
            status = "Normal Weight";
            guidance = "Great job! Maintain a balanced diet and regular exercise routine.";
            colorClass = "text-green";
        } else if (bmi < 29.9) {
            status = "Overweight";
            guidance = "Consider a balanced diet and increased physical activity to manage weight.";
            colorClass = "text-orange";
        } else {
            status = "Obese";
            guidance = "Consult a healthcare provider for a personalized weight management plan.";
            colorClass = "text-red";
        }

        model.addAttribute("bmiValue", bmiValue);
        model.addAttribute("bmiStatus", status);
        model.addAttribute("bmiGuidance", guidance);
        model.addAttribute("colorClass", colorClass);
        model.addAttribute("height", height);
        model.addAttribute("weight", weight);

        return "bmi_calculator";
    }
}
