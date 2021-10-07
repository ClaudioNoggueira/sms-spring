package com.claudionogueira.sms.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.claudionogueira.sms.entities.Student;
import com.claudionogueira.sms.repositories.StudentRepository;
import com.claudionogueira.sms.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository repo;

	public StudentServiceImpl(StudentRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Student> listAllStudents() {
		return repo.findAll();
	}

}
