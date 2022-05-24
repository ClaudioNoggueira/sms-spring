package com.claudionogueira.sms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.claudionogueira.sms.entities.Student;
import com.claudionogueira.sms.services.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "SMS API REST")
public class StudentController {

	private StudentService service;

	public StudentController(StudentService service) {
		this.service = service;
	}

	// handler method to handle list students and return model and view
	@GetMapping("/students")
	@ApiOperation(value = "Return list of all students")
	public String listStudents(Model model) {
		model.addAttribute("students", service.listAllStudents());
		return "students";
	}

	@GetMapping("/students/new")
	@ApiOperation(value = "Returns create_student page")
	public String createStudentForm(Model model) {
		// create student object to hold student form data
		Student obj = new Student();
		model.addAttribute("student", obj);

		return "create_student";
	}

	@PostMapping("/students")
	@ApiOperation(value = "Add new student")
	public String addStudent(@ModelAttribute("student") Student obj) {
		service.addStudent(obj);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	@ApiOperation(value = "Returns edit_student page")
	public String editStudentForm(@PathVariable Integer id, Model model) {
		model.addAttribute("student", service.findStudentById(id));
		return "edit_student";
	}

	@PostMapping("students/{id}")
	@ApiOperation(value = "Update student info based on it's ID")
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

	// handler method to handle delete student request
	@GetMapping("/students/{id}")
	@ApiOperation(value = "Delete student based on ID")
	public String deleteStudent(@PathVariable Integer id) {
		service.deleteStudentById(id);
		return "redirect:/students";
	}

}
