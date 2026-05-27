package com.healthTracker.implementation.repository;

import com.healthTracker.implementation.model.TrainerRequest;
import com.healthTracker.implementation.model.TrainerRequest.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainerRequestRepository extends JpaRepository<TrainerRequest, Long> {

    List<TrainerRequest> findByTrainerIdAndStatus(Long trainerId, RequestStatus status);

    List<TrainerRequest> findByUserId(Long userId);

    Optional<TrainerRequest> findByUserIdAndTrainerId(Long userId, Long trainerId);

    boolean existsByUserIdAndTrainerIdAndStatus(Long userId, Long trainerId, RequestStatus status);
}
