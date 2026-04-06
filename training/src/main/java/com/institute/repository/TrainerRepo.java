package com.institute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.institute.model.Trainer;

public interface TrainerRepo extends JpaRepository<Trainer, Integer> {
}