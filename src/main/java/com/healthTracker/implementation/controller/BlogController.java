package com.healthTracker.implementation.controller;

import com.healthTracker.implementation.dto.BlogDTO;
import com.healthTracker.implementation.dto.BlogCommentDTO;
import com.healthTracker.implementation.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            @RequestParam(required = false) String category) {
        List<BlogDTO> blogs;
        if (category != null && !category.isEmpty()) {
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

    @PostMapping
    public ResponseEntity<BlogDTO> createBlog(@RequestBody BlogDTO blogDTO) {
        BlogDTO createdBlog = blogService.createBlog(blogDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBlog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogDTO> updateBlog(@PathVariable Long id, @RequestBody BlogDTO blogDTO,
            java.security.Principal principal) {
        if (principal == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        try {
            BlogDTO existingBlog = blogService.getBlogById(id);
            if (!canManageBlog(existingBlog, principal)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
            BlogDTO updatedBlog = blogService.updateBlog(id, blogDTO);
            return ResponseEntity.ok(updatedBlog);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
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
        if (principal == null)
            return false;
        String currentUsername = principal.getName();
        com.healthTracker.implementation.model.User user = userService.getUserByUsername(currentUsername);

        String fullName = user.getFirst() + " " + user.getLast();
        boolean isAdmin = user.getRole() != null && user.getRole().equalsIgnoreCase("ADMIN");

        return blog.getAuthorName().equals(fullName) || blog.getAuthorName().equals(currentUsername) || isAdmin;
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
