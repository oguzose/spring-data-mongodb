package com.ozkaraca.mongodemo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Document
public class Student {

    @Id
    private String id;
    private String name;
    private String surname;
    @Indexed(unique = true)
    private String email;
    private String gender;
    private Address address;
    private List<String> favoriteSubjects;
    private BigDecimal totalSpendInBooks;
    private LocalDateTime created;

    public Student(String name, String surname, String email, String gender, Address address,
                   List<String> favoriteSubjects, BigDecimal totalSpendInBooks, LocalDateTime created) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favoriteSubjects = favoriteSubjects;
        this.totalSpendInBooks = totalSpendInBooks;
        this.created = created;
    }
}
