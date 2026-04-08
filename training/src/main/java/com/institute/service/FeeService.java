package com.institute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.institute.model.Fee;
import com.institute.repository.FeeRepo;

@Service
public class FeeService {

    @Autowired
    FeeRepo repo;

    public List<Fee> getAll() {
        return repo.findAll();
    }

    public Fee getById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Fee f) {
        repo.save(f);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}