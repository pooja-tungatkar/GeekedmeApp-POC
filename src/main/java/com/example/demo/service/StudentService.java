package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentService 
{
	private StudentRepo srepo;
	
	public StudentService(StudentRepo srepo) {
		super();
		this.srepo = srepo;
	}

	public Student saveStudent(Student student)
	{
		return srepo.save(student); 
	}

	public List<Student> getAllStudents() 
	{
		return srepo.findAll();
	}
	
	public Integer isStudentPresent(Student student)
	{
		Student student1=srepo.getStudentByEmailAndName(student.getEmail(), student.getSname());
			
		return student1 != null ? student1.getSid():null;	
	}
}
