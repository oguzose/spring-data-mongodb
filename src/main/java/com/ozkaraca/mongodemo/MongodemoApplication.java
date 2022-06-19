package com.ozkaraca.mongodemo;

import com.ozkaraca.mongodemo.models.Address;
import com.ozkaraca.mongodemo.models.Student;
import com.ozkaraca.mongodemo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class MongodemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository studentRepository, MongoTemplate mongoTemplate) {
		return args -> {
			Address address = new Address("Istanbul", "Maltape", "34001");

			var email = "demoMail3";
			Student student = new Student("Oguz", "Ozkaraca", email,
					"Male",  address, List.of("Math", "Algo"),
					new BigDecimal(1), LocalDateTime.now()
			);

			Optional<Student> studentByMail = studentRepository.findStudentByEmail(email);
			studentByMail.ifPresentOrElse(s ->  System.out.println(s + "already exist"), () -> {
				studentRepository.insert(student);
			});
			// extractedMongoTemplateAndQuery(studentRepository, mongoTemplate, email, student);
		};
	}

	private void extractedMongoTemplateAndQuery(StudentRepository studentRepository, MongoTemplate mongoTemplate, String email, Student student) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		List<Student> students = mongoTemplate.find(query, Student.class);
		if (students.size() > 1) {
			throw new IllegalStateException("too many students");
		}

		if (students.isEmpty()) {
			studentRepository.insert(student);
		} else {
			System.out.println("Student already exist");
		}
	}

}
