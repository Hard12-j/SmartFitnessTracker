package com.healthTracker.implementation.service;

import com.healthTracker.implementation.model.TrainerRequest;
import com.healthTracker.implementation.model.TrainerRequest.RequestStatus;
import com.healthTracker.implementation.model.User;
import com.healthTracker.implementation.repository.TrainerRequestRepository;
import com.healthTracker.implementation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerRequestService {

    @Autowired
    private TrainerRequestRepository trainerRequestRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * User sends a request to a trainer. Only one active (PENDING) request per trainer is allowed.
     */
    public String sendRequest(Long userId, Long trainerId) {
        // Prevent duplicate pending requests
        if (trainerRequestRepository.existsByUserIdAndTrainerIdAndStatus(userId, trainerId, RequestStatus.PENDING)) {
            return "ALREADY_PENDING";
        }
        // Check if already accepted
        if (trainerRequestRepository.existsByUserIdAndTrainerIdAndStatus(userId, trainerId, RequestStatus.ACCEPTED)) {
            return "ALREADY_ASSIGNED";
        }

        TrainerRequest request = new TrainerRequest();
        request.setUserId(userId);
        request.setTrainerId(trainerId);
        request.setStatus(RequestStatus.PENDING);
        trainerRequestRepository.save(request);
        return "SENT";
    }

    /**
     * Trainer accepts a pending request. Sets user's assignedTrainerId and updates status.
     */
    @Transactional
    public boolean acceptRequest(Long requestId, Long trainerId) {
        Optional<TrainerRequest> optReq = trainerRequestRepository.findById(requestId);
        if (optReq.isEmpty()) return false;

        TrainerRequest req = optReq.get();
        // Security: only the intended trainer can accept
        if (!req.getTrainerId().equals(trainerId)) return false;
        if (req.getStatus() != RequestStatus.PENDING) return false;

        // Assign trainer to user
        userRepository.findById(req.getUserId()).ifPresent(user -> {
            user.setAssignedTrainerId(trainerId);
            userRepository.save(user);
        });

        req.setStatus(RequestStatus.ACCEPTED);
        trainerRequestRepository.save(req);
        return true;
    }

    /**
     * Trainer rejects a pending request.
     */
    @Transactional
    public boolean rejectRequest(Long requestId, Long trainerId) {
        Optional<TrainerRequest> optReq = trainerRequestRepository.findById(requestId);
        if (optReq.isEmpty()) return false;

        TrainerRequest req = optReq.get();
        if (!req.getTrainerId().equals(trainerId)) return false;
        if (req.getStatus() != RequestStatus.PENDING) return false;

        req.setStatus(RequestStatus.REJECTED);
        trainerRequestRepository.save(req);
        return true;
    }

    /**
     * Returns all PENDING requests for a given trainer.
     */
    public List<TrainerRequest> getPendingRequestsForTrainer(Long trainerId) {
        return trainerRequestRepository.findByTrainerIdAndStatus(trainerId, RequestStatus.PENDING);
    }

    /**
     * Gets the current request status for a user→trainer pair, or null if none.
     */
    public RequestStatus getRequestStatus(Long userId, Long trainerId) {
        return trainerRequestRepository.findByUserIdAndTrainerId(userId, trainerId)
                .map(TrainerRequest::getStatus)
                .orElse(null);
    }

    /**
     * Gets all requests by a user (to show on user profile/dashboard).
     */
    public List<TrainerRequest> getRequestsByUser(Long userId) {
        return trainerRequestRepository.findByUserId(userId);
    }
}
