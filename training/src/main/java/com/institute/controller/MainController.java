package com.institute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.institute.model.AppUser;
import com.institute.repository.StudentRepo;
import com.institute.repository.CourseRepo;
import com.institute.repository.TrainerRepo;
import com.institute.repository.FeeRepo;
import com.institute.repository.UserRepository;

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

    @Autowired
    UserRepository userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

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

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestParam String username, @RequestParam String password) {
        // Hash password before saving
        String encodedPassword = passwordEncoder.encode(password);
        
        AppUser user = new AppUser();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        user.setRole("USER");
        
        userRepo.save(user);
        
        return "redirect:/login?registered";
    }
}