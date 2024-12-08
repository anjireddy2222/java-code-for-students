package com.example.demo.pojo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ResetPassword {
	
	@NotNull( message = "Password reset key is required")
	private String linkId;
	
	@NotNull(message = "password required")
	@Size( min = 8, message = "Password min 8 characters")
	private String password;
	
	@NotNull(message = "Confirm password required")
	@Size( min = 8, message = "Confirm password min 8 characters")
	private String confirmPassword;
}
