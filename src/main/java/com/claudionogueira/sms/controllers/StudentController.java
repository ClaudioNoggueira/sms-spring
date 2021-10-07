package com.claudionogueira.sms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.claudionogueira.sms.services.StudentService;

@Controller
public class StudentController {

	private StudentService service;

	public StudentController(StudentService service) {
		this.service = service;
	}
	
	//handler method to handle list students and return model and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", service.listAllStudents());
		return "students";
	}

}
