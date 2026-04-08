package com.institute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.institute.model.Student;
import com.institute.model.Course;
import com.institute.service.StudentService;
import com.institute.service.CourseService;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    // show students page with course list for the dropdown
    @GetMapping("/students")
    public String getAll(Model m) {
        m.addAttribute("list", studentService.getAll());
        m.addAttribute("courses", courseService.getAll());
        return "students";
    }

    // save student - receives course_id from form and sets the Course entity
    @PostMapping("/saveStudent")
    public String save(@RequestParam(required=false) Integer id,
                       @RequestParam String name,
                       @RequestParam String phone,
                       @RequestParam("course.id") int courseId) {

        Course course = courseService.getById(courseId);
        Student student;
        if (id != null) {
            student = studentService.getById(id);
        } else {
            student = new Student();
        }
        student.setName(name);
        student.setPhone(phone);
        student.setCourse(course);

        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/editStudent/{id}")
    public String edit(@PathVariable int id, Model m) {
        m.addAttribute("student", studentService.getById(id));
        m.addAttribute("courses", courseService.getAll());
        return "edit_student";
    }

    // delete student
    @GetMapping("/deleteStudent/{id}")
    public String delete(@PathVariable int id) {
        studentService.delete(id);
        return "redirect:/students";
    }
}