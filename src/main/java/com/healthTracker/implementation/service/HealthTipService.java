package com.healthTracker.implementation.service;

import com.healthTracker.implementation.model.HealthTip;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class HealthTipService {

    private final List<HealthTip> tips = new ArrayList<>();
    private final Random random = new Random();

    public HealthTipService() {
        // Initialize with a curated list of tips
        tips.add(new HealthTip("Stay Hydrated",
                "Drink at least 8 glasses of water daily to maintain optimal health and energy levels.", "Hydration"));
        tips.add(new HealthTip("Prioritize Sleep",
                "Aim for 7-9 hours of quality sleep each night to aid recovery and focus.", "Sleep"));
        tips.add(new HealthTip("Move Your Body",
                "Take a short 10-minute walk after meals to help digestion and blood sugar control.", "Exercise"));
        tips.add(new HealthTip("Eat More Greens",
                "Include a serving of leafy greens in at least one meal today for essential vitamins.", "Nutrition"));
        tips.add(new HealthTip("Mindful Breathing",
                "Take 5 minutes to practice deep breathing to reduce stress and anxiety.", "Mental Health"));
        tips.add(new HealthTip("Limit Sugar", "Try to replace sugary snacks with fruits or nuts for sustained energy.",
                "Nutrition"));
        tips.add(new HealthTip("Stretch Daily", "Stretching improves flexibility and reduces the risk of injury.",
                "Exercise"));
        tips.add(new HealthTip("Screen Detox",
                "Avoid screens for at least 30 minutes before bed to improve sleep quality.", "Sleep"));
    }

    public HealthTip getDailyTip() {
        // For a true "daily" tip, we could seed Random with the date,
        // but for a dynamic dashboard feeling, a random tip on reload is often more
        // engaging.
        // Let's go with random for now as per plan.
        int index = random.nextInt(tips.size());
        return tips.get(index);
    }
}
