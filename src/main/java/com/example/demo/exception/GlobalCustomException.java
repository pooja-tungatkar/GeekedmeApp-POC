package com.example.demo.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalCustomException 
{	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> resourceNotFound(ResourceNotFoundException ex,WebRequest request)
	{
		ErrorDetails er=new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(er,HttpStatus.NOT_FOUND);
	}
	
	//handel global exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> globalException(Exception ex,WebRequest request)
	{
		ErrorDetails er=new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(er,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
