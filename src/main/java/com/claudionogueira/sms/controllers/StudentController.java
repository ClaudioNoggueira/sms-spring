package com.claudionogueira.sms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.claudionogueira.sms.entities.Student;
import com.claudionogueira.sms.services.StudentService;

@Controller
public class StudentController {

	private StudentService service;

	public StudentController(StudentService service) {
		this.service = service;
	}

	// handler method to handle list students and return model and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", service.listAllStudents());
		return "students";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		// create student object to hold student form data
		Student obj = new Student();
		model.addAttribute("student", obj);

		return "create_student";
	}

	@PostMapping("/students")
	public String addStudent(@ModelAttribute("student") Student obj) {
		service.addStudent(obj);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Integer id, Model model) {
		model.addAttribute("student", service.findStudentById(id));
		return "edit_student";
	}

	@PostMapping("students/{id}")
	public String updateStudent(@PathVariable Integer id, @ModelAttribute("student") Student obj, Model model) {
		// get student from database by id
		Student existingStudent = service.findStudentById(id);
		existingStudent.setFirstName(obj.getFirstName());
		existingStudent.setLastName(obj.getLastName());
		existingStudent.setEmail(obj.getEmail());

		// save update student object
		service.updateStudent(existingStudent);

		return "redirect:/students";
	}

}
