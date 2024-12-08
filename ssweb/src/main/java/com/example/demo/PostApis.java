package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PostApis {
	
	
	@PostMapping("v1/login")
	public String login(@RequestBody LoginData loginData ) {
		
		String dbEmail = "contact@softwareschool.co";
		String dbPwordString = "12345678";

		if( dbEmail.equals(loginData.getEmail()) && dbPwordString.equals(loginData.getPassword()) ) {
			return "Login success";
		}else {
			return "Invalid login credentials";
		}
		
	}
	
	
	@PostMapping("auth/signup")
	public String signup(@RequestBody UserData signupData) {
		
		return "Signup successful: " + signupData.getEmail();
		
	}
	
	@PostMapping("auth/signup/v2")
	public String signupV2(@ModelAttribute UserData signupData) {
		
		return "Signup successful: " + signupData.toString();
		
	}
	
	@PostMapping("auth/reset-password")
	public String resetPassword(@RequestParam String emailId) {
		return "mail sent. Please check your inbox. " + emailId;
	}
	

}
