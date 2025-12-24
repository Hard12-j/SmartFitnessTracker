package com.healthTracker.implementation.repository;

import com.healthTracker.implementation.model.PasswordResetToken;
import com.healthTracker.implementation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    PasswordResetToken findByToken(String token);

    void deleteByUser(User user);

    PasswordResetToken findByUser(User user);
}
