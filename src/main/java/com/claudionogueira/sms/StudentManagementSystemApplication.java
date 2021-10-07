package com.claudionogueira.sms;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.claudionogueira.sms.entities.Student;
import com.claudionogueira.sms.repositories.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository repo;

	@Override
	public void run(String... args) throws Exception {
		Student student1 = new Student(1, "Claudio", "Nogueira", "cllaudionoggueira@gmail.com");
		Student student2 = new Student(2, "Maria", "Silva", "mariasilva@gmail.com");
		Student student3 = new Student(3, "Ana", "Santos", "anasantos@gmail.com");
		Student student4 = new Student(3, "José", "Carvalho", "josecarvalho@gmail.com");

		repo.saveAll(Arrays.asList(student1, student2, student3, student4));
	}

}
