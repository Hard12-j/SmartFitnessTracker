package com.healthTracker.implementation.repository;

import com.healthTracker.implementation.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByStatusOrderByPublishedDateDesc(String status);

    List<Blog> findByCategoryOrderByPublishedDateDesc(String category);

    List<Blog> findByAuthorNameOrderByPublishedDateDesc(String authorName);

    @Query("SELECT b FROM Blog b ORDER BY b.publishedDate DESC")
    List<Blog> findAllOrderByPublishedDateDesc();
}
