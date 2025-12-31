package com.healthTracker.implementation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.repository.UserRepository;
import org.springframework.util.ObjectUtils;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User updateUserProfile(User user) {
        User dbUser = userRepository.findById(user.getId()).get();
        if (!ObjectUtils.isEmpty(dbUser)) {
            dbUser.setAge(user.getAge());
            dbUser.setWeight(user.getWeight());
            dbUser.setHeight(user.getHeight());
            dbUser.setGoals(user.getGoals());
            if (user.getDailyStepGoal() != null)
                dbUser.setDailyStepGoal(user.getDailyStepGoal());
            if (user.getWeeklyWorkoutGoal() != null)
                dbUser.setWeeklyWorkoutGoal(user.getWeeklyWorkoutGoal());
            if (user.getProfileImageUrl() != null)
                dbUser.setProfileImageUrl(user.getProfileImageUrl());

            // Update trainer fields if they are provided
            if (user.getSpecialization() != null)
                dbUser.setSpecialization(user.getSpecialization());
            if (user.getTrainerLocation() != null)
                dbUser.setTrainerLocation(user.getTrainerLocation());
            if (user.getAvailability() != null)
                dbUser.setAvailability(user.getAvailability());
            if (user.getExperience() != null)
                dbUser.setExperience(user.getExperience());
            if (user.getContactNo() != null)
                dbUser.setContactNo(user.getContactNo());

            userRepository.save(dbUser);
        }
        return dbUser;
    }

    @Autowired
    private com.healthTracker.implementation.repository.PasswordResetTokenRepository tokenRepository;

    @org.springframework.transaction.annotation.Transactional
    public String createPasswordResetTokenForUser(User user) {
        String token = String.valueOf(new java.util.Random().nextInt(900000) + 100000);
        com.healthTracker.implementation.model.PasswordResetToken myToken = tokenRepository.findByUser(user);
        if (myToken != null) {
            myToken.setToken(token);
            myToken.setExpiryDate(java.time.LocalDateTime.now().plusHours(1));
            tokenRepository.save(myToken);
        } else {
            myToken = new com.healthTracker.implementation.model.PasswordResetToken(token, user);
            tokenRepository.save(myToken);
        }
        return token;
    }

    public String validatePasswordResetToken(String token) {
        com.healthTracker.implementation.model.PasswordResetToken passToken = tokenRepository.findByToken(token);

        return !isTokenFound(passToken) ? "invalidToken"
                : isTokenExpired(passToken) ? "expired"
                        : null;
    }

    private boolean isTokenFound(com.healthTracker.implementation.model.PasswordResetToken passToken) {
        return passToken != null;
    }

    private boolean isTokenExpired(com.healthTracker.implementation.model.PasswordResetToken passToken) {
        final java.time.LocalDateTime cal = passToken.getExpiryDate();
        return cal.isBefore(java.time.LocalDateTime.now());
    }

    public User getUserByPasswordResetToken(String token) {
        return tokenRepository.findByToken(token).getUser();
    }

    public void changeUserPassword(User user, String password) {
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
