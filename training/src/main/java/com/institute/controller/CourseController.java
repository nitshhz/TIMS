package com.institute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.institute.service.CourseService;

@Controller
public class CourseController {

    @Autowired
    CourseService s;

    @GetMapping("/courses")
    public String getAll(Model m) {
        m.addAttribute("list", s.getAll());
        return "courses";
    }

    @PostMapping("/saveCourse")
    public String save(com.institute.model.Course c) {
        s.save(c);
        return "redirect:/courses";
    }

    @GetMapping("/deleteCourse/{id}")
    public String delete(@PathVariable int id) {
        s.delete(id);
        return "redirect:/courses";
    }
}