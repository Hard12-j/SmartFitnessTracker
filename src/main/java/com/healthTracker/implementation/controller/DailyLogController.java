package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.model.DailyLog;
import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.service.DailyLogService;
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
@RequestMapping("/daily-logs")
public class DailyLogController {

    @Autowired
    private DailyLogService dailyLogService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String listDailyLogs(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        List<DailyLog> dailyLogs = dailyLogService.findDailyLogsByUser(user);
        model.addAttribute("dailyLogs", dailyLogs);
        model.addAttribute("dailyLog", new DailyLog());
        return "daily-log";
    }

    @PostMapping
    public String addDailyLog(@ModelAttribute DailyLog dailyLog, Principal principal) {
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        dailyLog.setUser(user);
        dailyLogService.saveDailyLog(dailyLog);
        return "redirect:/daily-logs";
    }
}
