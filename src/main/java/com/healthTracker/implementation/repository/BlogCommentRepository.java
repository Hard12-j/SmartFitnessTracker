package com.healthTracker.implementation.repository;

import com.healthTracker.implementation.model.BlogComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogCommentRepository extends JpaRepository<BlogComment, Long> {
    List<BlogComment> findByBlogIdOrderByCreatedAtAsc(Long blogId);
}
