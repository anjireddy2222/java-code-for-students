package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Authnetication {
	
	@GetMapping("auth-login")
	public String login() {
		System.out.println("Login API...");
		return "Login successful....!";
	}
	
	@GetMapping("create-account")
	public String signup() {
		System.out.println("Signup API");
		return "Account created";
	}
		
	public void resetPassword() {
		System.out.println("Reset Password API");
	}
	
}



