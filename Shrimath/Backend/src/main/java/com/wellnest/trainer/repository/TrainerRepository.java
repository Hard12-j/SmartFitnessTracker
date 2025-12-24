package com.wellnest.trainer.repository;

import com.wellnest.trainer.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    @Query("SELECT DISTINCT t FROM Trainer t JOIN t.specializations s WHERE s.specialization = :specialization")
    List<Trainer> findBySpecialization(String specialization);
    
    List<Trainer> findByLocation(String location);
}

