package com.institute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.institute.model.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {
}