package com.wellnest.trainer.repository;

import com.wellnest.trainer.entity.TrainerSpecialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerSpecializationRepository extends JpaRepository<TrainerSpecialization, Long> {
    List<TrainerSpecialization> findByTrainerId(Long trainerId);
    
    List<TrainerSpecialization> findBySpecialization(String specialization);
}

