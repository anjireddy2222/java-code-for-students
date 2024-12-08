package com.example.demo.pojo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupApiData {
	// name, email, password, mobile
	
	@NotNull( message = "Name required" )
	@Size( min = 2, message = "Min 2 characters")
	private String name;
	
	@NotNull( message = "Email required" )
	@Pattern( regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email is invalid")
	private String email;
	
	@NotNull( message = "password required" )
	@Size( min = 8, message = "Min 8 characters")
	private String password;
	
	@NotNull( message = "Mobile required" )
	@Size( min = 10, message = "Min 10 characters")
	private String mobile;
	
}
