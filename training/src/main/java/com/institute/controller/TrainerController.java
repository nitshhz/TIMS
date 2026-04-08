package com.institute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.institute.model.Trainer;
import com.institute.model.Course;
import com.institute.service.TrainerService;
import com.institute.service.CourseService;

@Controller
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    @Autowired
    CourseService courseService;

    @GetMapping("/trainers")
    public String getAll(Model m) {
        m.addAttribute("list", trainerService.getAll());
        m.addAttribute("courses", courseService.getAll());
        return "trainers";
    }

    @PostMapping("/saveTrainer")
    public String save(@RequestParam(required=false) Integer id,
                       @RequestParam String name,
                       @RequestParam String subject,
                       @RequestParam String phone,
                       @RequestParam(value = "course.id", required = false) Integer courseId) {

        Trainer trainer;
        if (id != null) {
            trainer = trainerService.getById(id);
        } else {
            trainer = new Trainer();
        }
        trainer.setName(name);
        trainer.setSubject(subject);
        trainer.setPhone(phone);

        if (courseId != null) {
            Course course = courseService.getById(courseId);
            trainer.setCourse(course);
        } else {
            trainer.setCourse(null);
        }

        trainerService.save(trainer);
        return "redirect:/trainers";
    }

    @GetMapping("/editTrainer/{id}")
    public String edit(@PathVariable int id, Model m) {
        m.addAttribute("trainer", trainerService.getById(id));
        m.addAttribute("courses", courseService.getAll());
        return "edit_trainer";
    }

    @GetMapping("/deleteTrainer/{id}")
    public String delete(@PathVariable int id) {
        trainerService.delete(id);
        return "redirect:/trainers";
    }
}