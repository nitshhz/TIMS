package com.institute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.institute.model.Student;
import com.institute.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    StudentService s;

    // show students page
    @GetMapping("/students")
    public String getAll(Model m) {

        m.addAttribute("list", s.getAll()); // get all students

        return "students"; // open students.html
    }

    // save student
    @PostMapping("/saveStudent")
    public String save(Student st) {

        s.save(st); // save to db

        return "redirect:/students";
    }

    // delete student
    @GetMapping("/deleteStudent/{id}")
    public String delete(@PathVariable int id) {

        s.delete(id);

        return "redirect:/students";
    }

}