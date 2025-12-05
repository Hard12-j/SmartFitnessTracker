package com.healthTracker.implementation.repository;

import com.healthTracker.implementation.model.DailyLog;
import com.healthTracker.implementation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyLogRepository extends JpaRepository<DailyLog, Long> {
    List<DailyLog> findByUser(User user);
}
