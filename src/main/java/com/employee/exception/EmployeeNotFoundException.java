package com.employee.exception;

public class EmployeeNotFoundException extends Exception{

	private String message;
	
	public EmployeeNotFoundException(String msg) {
		super(msg);
		this.message = msg;
	}
}
