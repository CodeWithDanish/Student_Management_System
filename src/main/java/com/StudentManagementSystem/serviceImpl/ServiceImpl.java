package com.StudentManagementSystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.repository.Studentrepository;
import com.StudentManagementSystem.service.StudentService;

@Service
public class ServiceImpl implements StudentService{
	
	@Autowired
	private Studentrepository repository;

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		
		return repository.findAll();
	}
	
	@Override
	public Student saveStudent(Student student) {
		return repository.save(student);
	}
	
	@Override
	public Student getById(int id) {
		
		return repository.findById(id).get();
		
	}
	
	@Override
	public void deleteById(int id) {
		
		repository.deleteById(id);
	}

}
