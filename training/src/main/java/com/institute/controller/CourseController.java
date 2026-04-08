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
    public String save(@RequestParam(required = false) Integer id, 
                       @RequestParam String name, 
                       @RequestParam String duration, 
                       @RequestParam Double fee) {
        com.institute.model.Course c;
        if (id != null) {
            c = s.getById(id);
        } else {
            c = new com.institute.model.Course();
        }
        c.setName(name);
        c.setDuration(duration);
        c.setFee(fee);
        s.save(c);
        return "redirect:/courses";
    }

    @GetMapping("/editCourse/{id}")
    public String edit(@PathVariable int id, Model m) {
        m.addAttribute("course", s.getById(id));
        return "edit_course";
    }

    @GetMapping("/deleteCourse/{id}")
    public String delete(@PathVariable int id) {
        s.delete(id);
        return "redirect:/courses";
    }
}