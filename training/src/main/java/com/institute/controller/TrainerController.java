package com.institute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.institute.service.TrainerService;

@Controller
public class TrainerController {

    @Autowired
    TrainerService s;

    @GetMapping("/trainers")
    public String getAll(Model m) {
        m.addAttribute("list", s.getAll());
        return "trainers";
    }

    @PostMapping("/saveTrainer")
    public String save(com.institute.model.Trainer t) {
        s.save(t);
        return "redirect:/trainers";
    }

    @GetMapping("/deleteTrainer/{id}")
    public String delete(@PathVariable int id) {
        s.delete(id);
        return "redirect:/trainers";
    }
}