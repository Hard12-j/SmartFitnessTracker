package com.healthTracker.implementation.service;

import com.healthTracker.implementation.dto.BlogDTO;
import com.healthTracker.implementation.dto.BlogCommentDTO;
import com.healthTracker.implementation.model.Blog;
import com.healthTracker.implementation.model.BlogComment;
import com.healthTracker.implementation.model.BlogLike;
import com.healthTracker.implementation.repository.BlogCommentRepository;
import com.healthTracker.implementation.repository.BlogLikeRepository;
import com.healthTracker.implementation.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private BlogCommentRepository commentRepository;

    @Autowired
    private BlogLikeRepository likeRepository;

    public List<BlogDTO> getAllBlogs() {
        return blogRepository.findAllOrderByPublishedDateDesc().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<BlogDTO> getBlogsByCategory(String category) {
        return blogRepository.findByCategoryOrderByPublishedDateDesc(category).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BlogDTO getBlogById(Long id) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found with id: " + id));
        return convertToDTO(blog);
    }

    public BlogDTO createBlog(BlogDTO blogDTO) {
        Blog blog = new Blog();
        blog.setTitle(blogDTO.getTitle());
        blog.setCategory(blogDTO.getCategory());
        blog.setContent(blogDTO.getContent());
        blog.setAuthorName(blogDTO.getAuthorName());
        blog.setAuthorUsername(blogDTO.getAuthorUsername());
        blog.setAuthorType(blogDTO.getAuthorType());
        blog.setImageUrl(blogDTO.getImageUrl());
        blog.setStatus(blogDTO.getStatus() != null ? blogDTO.getStatus() : "PUBLISHED");

        Blog savedBlog = blogRepository.save(blog);
        return convertToDTO(savedBlog);
    }

    public BlogDTO updateBlog(Long id, BlogDTO blogDTO) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found with id: " + id));

        blog.setTitle(blogDTO.getTitle());
        blog.setCategory(blogDTO.getCategory());
        blog.setContent(blogDTO.getContent());
        blog.setImageUrl(blogDTO.getImageUrl());
        if (blogDTO.getStatus() != null) {
            blog.setStatus(blogDTO.getStatus());
        }

        Blog updatedBlog = blogRepository.save(blog);
        return convertToDTO(updatedBlog);
    }

    public void deleteBlog(Long id) {
        if (!blogRepository.existsById(id)) {
            throw new RuntimeException("Blog not found with id: " + id);
        }
        blogRepository.deleteById(id);
    }

    public List<BlogCommentDTO> getCommentsByBlogId(Long blogId) {
        return commentRepository.findByBlogIdOrderByCreatedAtAsc(blogId).stream()
                .map(this::convertCommentToDTO)
                .collect(Collectors.toList());
    }

    public BlogCommentDTO addComment(BlogCommentDTO commentDTO) {
        Blog blog = blogRepository.findById(commentDTO.getBlogId())
                .orElseThrow(() -> new RuntimeException("Blog not found with id: " + commentDTO.getBlogId()));

        BlogComment comment = new BlogComment();
        comment.setBlog(blog);
        comment.setUserName(commentDTO.getUserName());
        comment.setCommentText(commentDTO.getCommentText());

        BlogComment savedComment = commentRepository.save(comment);
        return convertCommentToDTO(savedComment);
    }

    public void deleteComment(Long commentId) {
        if (!commentRepository.existsById(commentId)) {
            throw new RuntimeException("Comment not found with id: " + commentId);
        }
        commentRepository.deleteById(commentId);
    }

    public boolean toggleLike(Long blogId, String userName) {
        Blog blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new RuntimeException("Blog not found with id: " + blogId));

        return likeRepository.findByBlogIdAndUserName(blogId, userName)
                .map(like -> {
                    likeRepository.delete(like);
                    return false; // Unlike
                })
                .orElseGet(() -> {
                    BlogLike like = new BlogLike();
                    like.setBlog(blog);
                    like.setUserName(userName);
                    likeRepository.save(like);
                    return true; // Like
                });
    }

    public boolean isLikedByUser(Long blogId, String userName) {
        return likeRepository.existsByBlogIdAndUserName(blogId, userName);
    }

    private BlogDTO convertToDTO(Blog blog) {
        BlogDTO dto = new BlogDTO();
        dto.setId(blog.getId());
        dto.setTitle(blog.getTitle());
        dto.setCategory(blog.getCategory());
        dto.setContent(blog.getContent());
        dto.setAuthorName(blog.getAuthorName());
        dto.setAuthorUsername(blog.getAuthorUsername());
        dto.setAuthorType(blog.getAuthorType());
        dto.setPublishedDate(blog.getPublishedDate());
        dto.setImageUrl(blog.getImageUrl());
        dto.setStatus(blog.getStatus());
        dto.setLikesCount(likeRepository.countByBlogId(blog.getId()));
        dto.setCommentsCount(commentRepository.findByBlogIdOrderByCreatedAtAsc(blog.getId()).size());
        return dto;
    }

    private BlogCommentDTO convertCommentToDTO(BlogComment comment) {
        BlogCommentDTO dto = new BlogCommentDTO();
        dto.setId(comment.getId());
        dto.setBlogId(comment.getBlog().getId());
        dto.setUserName(comment.getUserName());
        dto.setCommentText(comment.getCommentText());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setUpdatedAt(comment.getUpdatedAt());
        return dto;
    }
}
