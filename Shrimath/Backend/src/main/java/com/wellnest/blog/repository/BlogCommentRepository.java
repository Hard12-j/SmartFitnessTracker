package com.wellnest.blog.repository;

import com.wellnest.blog.entity.BlogComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogCommentRepository extends JpaRepository<BlogComment, Long> {
    List<BlogComment> findByBlogIdOrderByCreatedAtAsc(Long blogId);
    
    List<BlogComment> findByUserName(String userName);
}

