package com.example.demo.service;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Programs;
import com.example.demo.repository.ProgramsRepo;

@Service
public class ProgramsService 
{
	ProgramsRepo prepo;

	public ProgramsService(ProgramsRepo prepo) {
		super();
		this.prepo = prepo;
	}
	
	public Programs createprogram(Programs program)
	{
		Programs createprogram=prepo.save(program);														
		return createprogram;
	}
	 public List<Programs> getAllPrograms()
	 {
		 return prepo.findAll();
	 }
}
