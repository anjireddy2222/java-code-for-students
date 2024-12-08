package com.example.demo.exception;

public class EmailNotFoundException extends RuntimeException {
	
	String email;

	public EmailNotFoundException(String message, String email) {
		super(message);
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
}
