package com.healthTracker.implementation.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.repository.UserRepository;

@Service
public class CustomUserDetails implements UserDetailsService {

	private UserRepository userRepository;

	public CustomUserDetails(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("user not found with given username");
		}

		boolean isEnabled = true;
		if ("TRAINER".equalsIgnoreCase(user.getRole())) {
			isEnabled = user.isVerifiedTrainer();
		}
		// USER and ADMIN are enabled by default

		if (!isEnabled) {
			throw new org.springframework.security.authentication.DisabledException(
					"Your account is pending admin verification.");
		}

		return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
				.password(user.getPassword())
				.roles(user.getRole().toUpperCase())
				.build();
	}

}
