package com.wellnest.trainer.repository;

import com.wellnest.trainer.entity.UserFitnessProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserFitnessProfileRepository extends JpaRepository<UserFitnessProfile, Long> {
    Optional<UserFitnessProfile> findByUserName(String userName);
}

