package com.healthTracker.implementation.service;

import com.healthTracker.implementation.model.DailyLog;
import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.repository.DailyLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyLogService {

    @Autowired
    private DailyLogRepository dailyLogRepository;

    public DailyLog saveDailyLog(DailyLog dailyLog) {
        return dailyLogRepository.save(dailyLog);
    }

    public List<DailyLog> findDailyLogsByUser(User user) {
        return dailyLogRepository.findByUser(user);
    }
}
