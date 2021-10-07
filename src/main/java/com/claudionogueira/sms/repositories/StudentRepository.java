package com.claudionogueira.sms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claudionogueira.sms.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
