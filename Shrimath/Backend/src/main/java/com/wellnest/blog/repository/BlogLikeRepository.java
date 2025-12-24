package com.wellnest.blog.repository;

import com.wellnest.blog.entity.BlogLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogLikeRepository extends JpaRepository<BlogLike, Long> {
    Optional<BlogLike> findByBlogIdAndUserName(Long blogId, String userName);
    
    long countByBlogId(Long blogId);
    
    boolean existsByBlogIdAndUserName(Long blogId, String userName);
}

