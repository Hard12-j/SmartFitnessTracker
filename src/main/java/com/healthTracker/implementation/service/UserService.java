package com.healthTracker.implementation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.repository.UserRepository;
import org.springframework.util.ObjectUtils;

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
        User dbUser =  userRepository.findById(user.getId()).get();
        if(!ObjectUtils.isEmpty(dbUser)) {
            dbUser.setAge(user.getAge());
            dbUser.setWeight(user.getWeight());
            dbUser.setHeight(user.getHeight());
            dbUser.setGoals(user.getGoals());
            userRepository.save(dbUser);
        }
        return dbUser;
    }

}
