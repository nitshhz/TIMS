package com.institute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.institute.model.Student;
import com.institute.repository.StudentRepo;

@Service
public class StudentService {

    @Autowired
    StudentRepo repo;

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student getById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Student s) {
        if (s != null) {
            repo.save(s);
        }
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}