package com.institute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.institute.repository.StudentRepo;
import com.institute.repository.CourseRepo;
import com.institute.repository.TrainerRepo;
import com.institute.repository.FeeRepo;

@Controller
public class MainController {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    TrainerRepo trainerRepo;

    @Autowired
    FeeRepo feeRepo;

    @GetMapping("/dashboard")
    public String dashboard(Model m) {

        long studentCount = studentRepo.count();
        long courseCount = courseRepo.count();
        long trainerCount = trainerRepo.count();
        long feeCount = feeRepo.count();

        m.addAttribute("students", studentCount);
        m.addAttribute("courses", courseCount);
        m.addAttribute("trainers", trainerCount);
        m.addAttribute("fees", feeCount);

        return "dashboard";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/dashboard";
    }
}