package com.wellnest.trainer.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "trainer_specializations")
public class TrainerSpecialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id", nullable = false)
    private Trainer trainer;

    @Column(nullable = false)
    private String specialization;

    public TrainerSpecialization() {
    }

    public TrainerSpecialization(Long id, Trainer trainer, String specialization) {
        this.id = id;
        this.trainer = trainer;
        this.specialization = specialization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "TrainerSpecialization{" +
                "id=" + id +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
