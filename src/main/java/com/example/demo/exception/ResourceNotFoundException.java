package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException
{
	
	private static final long serialVersionUID = 1L;
	
	String resourceName;
	String fieldName;
	long fieldValue;
	public ResourceNotFoundException(String resourceName) {
		super(String.format("%s not found with %s : %s"));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
}
