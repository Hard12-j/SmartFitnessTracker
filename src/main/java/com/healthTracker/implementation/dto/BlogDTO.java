package com.healthTracker.implementation.dto;

import java.time.LocalDateTime;

public class BlogDTO {
    private Long id;
    private String title;
    private String category;
    private String content;
    private String authorName;
    private String authorUsername;
    private String authorType;
    private LocalDateTime publishedDate;
    private String imageUrl;
    private String status;
    private long likesCount;
    private long commentsCount;
    private String contentType;

    public BlogDTO() {
    }

    public BlogDTO(Long id, String title, String category, String content, String authorName, String authorUsername,
            String authorType, LocalDateTime publishedDate, String imageUrl, String status, long likesCount,
            long commentsCount, String contentType) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.content = content;
        this.authorName = authorName;
        this.authorUsername = authorUsername;
        this.authorType = authorType;
        this.publishedDate = publishedDate;
        this.imageUrl = imageUrl;
        this.status = status;
        this.likesCount = likesCount;
        this.commentsCount = commentsCount;
        this.contentType = contentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String authorUsername) {
        this.authorUsername = authorUsername;
    }

    public String getAuthorType() {
        return authorType;
    }

    public void setAuthorType(String authorType) {
        this.authorType = authorType;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(long likesCount) {
        this.likesCount = likesCount;
    }

    public long getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(long commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "BlogDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", content='" + content + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorUsername='" + authorUsername + '\'' +
                ", authorType='" + authorType + '\'' +
                ", publishedDate=" + publishedDate +
                ", imageUrl='" + imageUrl + '\'' +
                ", status='" + status + '\'' +
                ", likesCount=" + likesCount +
                ", commentsCount=" + commentsCount +
                '}';
    }
}
