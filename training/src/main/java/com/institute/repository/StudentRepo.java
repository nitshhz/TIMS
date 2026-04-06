package com.institute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.institute.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}