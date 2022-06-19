package com.ozkaraca.mongodemo.repository;

import com.ozkaraca.mongodemo.models.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {

    @Override
    List<Student> findAll();

    Optional<Student> findStudentByEmail(String email);
}
