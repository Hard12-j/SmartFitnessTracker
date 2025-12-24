package com.healthTracker.implementation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogs")
public class BlogViewController {

    @GetMapping
    public String showBlogs() {
        return "blogs";
    }

    @GetMapping("/create")
    public String showCreateBlog() {
        return "blog-create";
    }

    @GetMapping("/edit")
    public String showEditBlog() {
        return "blog-edit";
    }

    @GetMapping("/detail")
    public String showBlogDetail() {
        return "blog-detail";
    }
}
