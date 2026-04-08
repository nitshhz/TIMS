package com.institute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.institute.model.Course;
import com.institute.repository.CourseRepo;

@Service
public class CourseService {

    @Autowired
    CourseRepo repo;

    public List<Course> getAll() {
        return repo.findAll();
    }

    public Course getById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Course c) {
        repo.save(c);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}