package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>
{
	@Query("SELECT s FROM Student s WHERE s.sname=?1 and s.email=?2")
	public Student getStudentByEmailAndName(String email,String sname);
}
