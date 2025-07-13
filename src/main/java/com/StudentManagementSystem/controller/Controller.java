package com.StudentManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.service.StudentService;
import com.StudentManagementSystem.serviceImpl.ServiceImpl;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private StudentService service;
	
	@GetMapping(path = "/home")
	public String home() {
		
		return "home";// htmp view
	}
	
	// data recieved from the db is transfered to view using model
	@GetMapping(path = "/students")
	public String getAllStudents(Model model) {
		
		model.addAttribute("students", service.getAllStudents());
		
		return "students";	
	}
	
	@GetMapping(path = "/students/new")
	public String CreateStudentForm(Model model) {
		
		Student student = new Student();// to hold student object
		model.addAttribute("student",student);	
		
		return "create-student";
		
	}
	
	@PostMapping(path = "/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		service.saveStudent(student);
		
		return "redirect:/students";
	}
	
	@GetMapping(path = "/students/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		
		model.addAttribute("student", service.getById(id));
		
		return "edit_student";
		
	}
	
	@PostMapping(path = "/students/edit/{id}")
public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student) {
		
		Student existingStudent = service.getById(id);
		
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		service.saveStudent(existingStudent);
		
		return "redirect:/students";
		
	}
	
	@GetMapping(path = "/students/{id}")
	public String deleteById(@PathVariable int id) {
		
		service.deleteById(id);
		return "redirect:/students";
		
	}
	
	
	 
}


