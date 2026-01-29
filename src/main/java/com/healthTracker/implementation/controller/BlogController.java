package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.dto.BlogDTO;
import com.healthTracker.implementation.dto.BlogCommentDTO;
import com.healthTracker.implementation.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin(origins = "*")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private com.healthTracker.implementation.service.UserService userService;

    @GetMapping
    public ResponseEntity<List<BlogDTO>> getAllBlogs(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String contentType,
            @RequestParam(required = false) String authorType) {
        List<BlogDTO> blogs;
        if (authorType != null && !authorType.isEmpty()) {
            blogs = blogService.getBlogsByAuthorType(authorType);
            if (category != null && !category.isEmpty()) {
                blogs = blogs.stream().filter(b -> category.equalsIgnoreCase(b.getCategory()))
                        .collect(java.util.stream.Collectors.toList());
            }
            if (contentType != null && !contentType.isEmpty()) {
                blogs = blogs.stream().filter(b -> contentType.equalsIgnoreCase(b.getContentType()))
                        .collect(java.util.stream.Collectors.toList());
            }
        } else if (contentType != null && !contentType.isEmpty()) {
            blogs = blogService.getBlogsByContentType(contentType);
            if (category != null && !category.isEmpty()) {
                blogs = blogs.stream().filter(b -> category.equalsIgnoreCase(b.getCategory()))
                        .collect(java.util.stream.Collectors.toList());
            }
        } else if (category != null && !category.isEmpty()) {
            blogs = blogService.getBlogsByCategory(category);
        } else {
            blogs = blogService.getAllBlogs();
        }
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDTO> getBlogById(@PathVariable Long id) {
        try {
            BlogDTO blog = blogService.getBlogById(id);
            return ResponseEntity.ok(blog);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity<BlogDTO> createBlog(
            @RequestPart("blog") BlogDTO blogDTO,
            @RequestPart(value = "image", required = false) MultipartFile image,
            java.security.Principal principal) {
        if (principal == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        String currentUsername = principal.getName();
        com.healthTracker.implementation.model.User user = userService.getUserByUsername(currentUsername);

        // Security Check: Unverified users cannot create Articles
        if ("USER".equalsIgnoreCase(user.getRole()) &&
                "ARTICLE".equalsIgnoreCase(blogDTO.getContentType()) &&
                !user.isVerifiedUser()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        blogDTO.setAuthorUsername(currentUsername);
        blogDTO.setAuthorName(user.getFirst() + " " + user.getLast());
        if (blogDTO.getAuthorType() == null) {
            blogDTO.setAuthorType(user.getRole() != null ? user.getRole() : "USER");
        }

        try {
            if (image != null && !image.isEmpty()) {
                String imageUrl = blogService.saveBlogImage(image);
                blogDTO.setImageUrl(imageUrl);
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        BlogDTO createdBlog = blogService.createBlog(blogDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBlog);
    }

    @PutMapping(value = "/{id}", consumes = { "multipart/form-data" })
    public ResponseEntity<BlogDTO> updateBlog(
            @PathVariable Long id,
            @RequestPart("blog") BlogDTO blogDTO,
            @RequestPart(value = "image", required = false) MultipartFile image,
            java.security.Principal principal) {
        if (principal == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        try {
            BlogDTO existingBlog = blogService.getBlogById(id);
            if (!canManageBlog(existingBlog, principal)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }

            if (image != null && !image.isEmpty()) {
                String imageUrl = blogService.saveBlogImage(image);
                blogDTO.setImageUrl(imageUrl);
            } else {
                // Preserve existing image if no new one is uploaded and no explicit URL is
                // provided
                if (blogDTO.getImageUrl() == null || blogDTO.getImageUrl().isEmpty()) {
                    blogDTO.setImageUrl(existingBlog.getImageUrl());
                }
            }

            BlogDTO updatedBlog = blogService.updateBlog(id, blogDTO);
            return ResponseEntity.ok(updatedBlog);
        } catch (RuntimeException | IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteBlog(@PathVariable Long id, java.security.Principal principal) {
        if (principal == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        try {
            BlogDTO existingBlog = blogService.getBlogById(id);
            if (!canManageBlog(existingBlog, principal)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
            blogService.deleteBlog(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Blog deleted successfully");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    private boolean canManageBlog(BlogDTO blog, java.security.Principal principal) {
        if (principal == null || blog == null)
            return false;
        String currentUsername = principal.getName().trim().toLowerCase();

        boolean usernameMatch = blog.getAuthorUsername() != null &&
                blog.getAuthorUsername().trim().toLowerCase().equals(currentUsername);
        boolean nameMatch = blog.getAuthorName() != null &&
                blog.getAuthorName().trim().toLowerCase().equals(currentUsername);

        return usernameMatch || nameMatch;
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<BlogCommentDTO>> getComments(@PathVariable Long id) {
        List<BlogCommentDTO> comments = blogService.getCommentsByBlogId(id);
        return ResponseEntity.ok(comments);
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity<BlogCommentDTO> addComment(@PathVariable Long id, @RequestBody BlogCommentDTO commentDTO,
            java.security.Principal principal) {
        if (principal == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        commentDTO.setBlogId(id);
        BlogCommentDTO createdComment = blogService.addComment(commentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<Map<String, String>> deleteComment(@PathVariable Long commentId,
            java.security.Principal principal) {
        if (principal == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        try {
            blogService.deleteComment(commentId);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Comment deleted successfully");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/like")
    public ResponseEntity<Map<String, Object>> toggleLike(@PathVariable Long id,
            @RequestBody Map<String, String> request) {
        try {
            String userName = request.get("userName");
            boolean isLiked = blogService.toggleLike(id, userName);
            Map<String, Object> response = new HashMap<>();
            response.put("liked", isLiked);
            response.put("likesCount", blogService.getBlogById(id).getLikesCount());
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/like-status")
    public ResponseEntity<Map<String, Boolean>> getLikeStatus(@PathVariable Long id, @RequestParam String userName) {
        try {
            boolean isLiked = blogService.isLikedByUser(id, userName);
            Map<String, Boolean> response = new HashMap<>();
            response.put("liked", isLiked);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
