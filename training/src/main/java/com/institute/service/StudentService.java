package com.institute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.institute.model.Student;
import com.institute.repository.StudentRepo;

@Service
public class StudentService {

    @Autowired
    StudentRepo r;

    // get all students
    public List<Student> getAll() {
        return r.findAll();
    }

    // save student
    public void save(Student s) {
        if(s != null) {
            r.save(s);
        }
    }

    // delete student
    public void delete(int id) {
        r.deleteById(id);
    }

}