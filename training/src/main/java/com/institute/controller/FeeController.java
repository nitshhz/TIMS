package com.institute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.institute.service.FeeService;

@Controller
public class FeeController {

    @Autowired
    FeeService s;

    @GetMapping("/fees")
    public String getAll(Model m) {
        m.addAttribute("list", s.getAll());
        return "fees";
    }

    @PostMapping("/saveFee")
    public String save(com.institute.model.Fee f) {
        s.save(f);
        return "redirect:/fees";
    }

    @GetMapping("/deleteFee/{id}")
    public String delete(@PathVariable int id) {
        s.delete(id);
        return "redirect:/fees";
    }
}