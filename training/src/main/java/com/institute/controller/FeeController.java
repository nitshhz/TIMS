package com.institute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.institute.model.Fee;
import com.institute.model.Student;
import com.institute.model.Course;
import com.institute.service.FeeService;
import com.institute.service.StudentService;
import com.institute.service.CourseService;

import java.time.LocalDate;

@Controller
public class FeeController {

    @Autowired
    FeeService feeService;

    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    @GetMapping("/fees")
    public String getAll(Model m) {
        m.addAttribute("list", feeService.getAll());
        m.addAttribute("students", studentService.getAll());
        m.addAttribute("courses", courseService.getAll());
        return "fees";
    }

    @PostMapping("/saveFee")
    public String save(@RequestParam(required=false) Integer id,
                       @RequestParam("student.id") int studentId,
                       @RequestParam("course.id") int courseId,
                       @RequestParam Double amount,
                       @RequestParam String paymentDate,
                       @RequestParam String paymentMode) {

        Student student = studentService.getById(studentId);
        Course course = courseService.getById(courseId);

        Fee fee;
        if (id != null) {
            fee = feeService.getById(id);
        } else {
            fee = new Fee();
        }
        fee.setStudent(student);
        fee.setCourse(course);
        fee.setAmount(amount);
        // Safely capture HTML parameter 'paymentDate' from layout
        fee.setDate(LocalDate.parse(paymentDate));
        fee.setPaymentMode(paymentMode);

        feeService.save(fee);
        return "redirect:/fees";
    }

    @GetMapping("/editFee/{id}")
    public String edit(@PathVariable int id, Model m) {
        m.addAttribute("fee", feeService.getById(id));
        m.addAttribute("students", studentService.getAll());
        m.addAttribute("courses", courseService.getAll());
        return "edit_fee";
    }

    @GetMapping("/deleteFee/{id}")
    public String delete(@PathVariable int id) {
        feeService.delete(id);
        return "redirect:/fees";
    }
}