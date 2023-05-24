package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Programs;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController
{
	StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("add")
	public ResponseEntity<Student> saveUser(@RequestBody Student student)
	{
		Student savestudent=service.saveStudent(student);
        return new ResponseEntity<>(savestudent, HttpStatus.CREATED);
		
	}
	
	@GetMapping("allStudent")
	public ResponseEntity<List<Student>> getAllStudents()
	{
		List<Student> studentList=service.getAllStudents();
		return new ResponseEntity<List<Student>>(studentList,HttpStatus.OK);
		
	}
}
