package com.ozkaraca.mongodemo.services;

import com.ozkaraca.mongodemo.models.Student;
import com.ozkaraca.mongodemo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        List<Student> allStudent = studentRepository.findAll();
        return allStudent;
    }
}
