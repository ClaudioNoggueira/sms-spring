package com.claudionogueira.sms.services;

import java.util.List;

import com.claudionogueira.sms.entities.Student;

public interface StudentService {

	List<Student> listAllStudents();
	
	Student findStudentById(Integer id);
	
	void addStudent(Student obj);
	
	void updateStudent(Student obj);
}
