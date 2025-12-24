package com.wellnest.blog.service;

import com.wellnest.blog.dto.BlogDTO;
import com.wellnest.blog.dto.BlogCommentDTO;
import com.wellnest.blog.entity.Blog;
import com.wellnest.blog.entity.BlogComment;
import com.wellnest.blog.entity.BlogLike;
import com.wellnest.blog.repository.BlogCommentRepository;
import com.wellnest.blog.repository.BlogLikeRepository;
import com.wellnest.blog.repository.BlogRepository;
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
    
    public BlogCommentDTO updateComment(Long commentId, BlogCommentDTO commentDTO) {
        BlogComment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + commentId));
        
        comment.setCommentText(commentDTO.getCommentText());
        BlogComment updatedComment = commentRepository.save(comment);
        return convertCommentToDTO(updatedComment);
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

