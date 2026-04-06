package com.institute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.institute.model.Trainer;
import com.institute.repository.TrainerRepo;

@Service
public class TrainerService {

    @Autowired
    TrainerRepo repo;

    public List<Trainer> getAll() {
        return repo.findAll();
    }

    public void save(Trainer t) {
        repo.save(t);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}