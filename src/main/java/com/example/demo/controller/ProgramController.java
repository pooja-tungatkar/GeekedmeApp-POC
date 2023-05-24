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
import com.example.demo.service.ProgramsService;

@RestController
@RequestMapping("programs")
public class ProgramController
{
	ProgramsService pservice;

	public ProgramController(ProgramsService pservice)
	{
		super();
		this.pservice = pservice;
	}
	
	@PostMapping("add")
	public ResponseEntity<Programs> savePrograms(@RequestBody Programs program)
	{
		Programs saveprogram=pservice.createprogram(program);
		return new ResponseEntity<Programs>(saveprogram,HttpStatus.CREATED);
	}
	
	@GetMapping("allPrograms")
	public ResponseEntity<List<Programs>> getAllPrograms()
	{
		List<Programs> programList=pservice.getAllPrograms();
		return new ResponseEntity<List<Programs>>(programList,HttpStatus.OK);
		
	}
}
