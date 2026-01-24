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
@RequestMapping("/blogs")
public class BlogViewController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showBlogs(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.getUserByUsername(principal.getName());
            model.addAttribute("user", user);
        }
        return "blogs";
    }

    @GetMapping("/create")
    public String showCreateBlog(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.getUserByUsername(principal.getName());
            model.addAttribute("user", user);
        }
        return "blog-create";
    }

    @GetMapping("/edit")
    public String showEditBlog(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.getUserByUsername(principal.getName());
            model.addAttribute("user", user);
        }
        return "blog-edit";
    }

    @GetMapping("/detail")
    public String showBlogDetail(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.getUserByUsername(principal.getName());
            model.addAttribute("user", user);
        }
        return "blog-detail";
    }
}
