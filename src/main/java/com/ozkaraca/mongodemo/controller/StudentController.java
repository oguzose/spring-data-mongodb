package com.ozkaraca.mongodemo.controller;

import com.ozkaraca.mongodemo.services.StudentService;
import com.ozkaraca.mongodemo.models.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAllStudent() {
       return studentService.getAllStudent();
    }
}
