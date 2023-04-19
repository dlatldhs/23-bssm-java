package com.sion.bssm.hellospring.controller;

import com.sion.bssm.hellospring.domain.Student;
import com.sion.bssm.hellospring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/new")
    public String createForm() {
        return "createStudentForm";
    }

    @PostMapping("/students/new")
    public String create(StudentForm form) {
        Student student = new Student();
        student.setId(form.getId());
        student.setName(form.getName());
        studentService.edit(student);
        return "redirect:/";
    }

    @GetMapping("/students")
    public String studentList(Model model) {
        List<Student> stu_list = studentService.findStudents();
        model.addAttribute("students",stu_list);
        return "students/studentList";
    }
}
