package com.healthTracker.implementation.service;

import com.healthTracker.implementation.model.DailyLog;
import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.repository.DailyLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DailyLogService {

    @Autowired
    private DailyLogRepository dailyLogRepository;

    public DailyLog saveDailyLog(DailyLog dailyLog) {
        return dailyLogRepository.save(dailyLog);
    }

    public List<DailyLog> findDailyLogsByUser(User user) {
        LocalDate startOfMonth = LocalDate.now().withDayOfMonth(1);
        LocalDate endOfMonth = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());

        return dailyLogRepository.findByUser(user).stream()
                .filter(l -> !l.getDate().isBefore(startOfMonth) && !l.getDate().isAfter(endOfMonth))
                .collect(Collectors.toList());
    }
}
