package com.example.demo.pojo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginApiData {

	@NotNull(message = "Email required")
	@Pattern( regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email is invalid")
	private String email;
	
	@NotNull( message = "Password is required")
	@Size(min = 8, message = "Password should be min 8 characters")
	private String password;
	
}
