package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/articles")
public class BlogViewController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showBlogs(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.getUserByUsername(principal.getName());
            model.addAttribute("user", user);
        }
        return "articles";
    }

    @GetMapping("/articles")
    public String showArticles(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.getUserByUsername(principal.getName());
            model.addAttribute("user", user);
        }
        return "articles";
    }

    @GetMapping("/community")
    public String showCommunity(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.getUserByUsername(principal.getName());
            model.addAttribute("user", user);
        }
        return "community";
    }

    @GetMapping("/create")
    public String showCreateBlog(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.getUserByUsername(principal.getName());
            model.addAttribute("user", user);
        }
        return "article-create";
    }

    @GetMapping("/edit")
    public String showEditBlog(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.getUserByUsername(principal.getName());
            model.addAttribute("user", user);
        }
        return "article-edit";
    }

    @GetMapping("/detail")
    public String showBlogDetail(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.getUserByUsername(principal.getName());
            model.addAttribute("user", user);
        }
        return "article-detail";
    }
}
