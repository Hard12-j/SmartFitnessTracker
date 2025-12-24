package com.healthTracker.implementation.dto;

import java.time.LocalDateTime;

public class BlogCommentDTO {
    private Long id;
    private Long blogId;
    private String userName;
    private String commentText;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BlogCommentDTO() {
    }

    public BlogCommentDTO(Long id, Long blogId, String userName, String commentText, LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.blogId = blogId;
        this.userName = userName;
        this.commentText = commentText;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "BlogCommentDTO{" +
                "id=" + id +
                ", blogId=" + blogId +
                ", userName='" + userName + '\'' +
                ", commentText='" + commentText + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
