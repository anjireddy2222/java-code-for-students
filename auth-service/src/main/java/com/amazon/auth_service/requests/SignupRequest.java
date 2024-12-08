package com.amazon.auth_service.requests;

import lombok.Data;

@Data
public class SignupRequest {

	public String name;
	public String email;
	public String password;
	public String mobile;
	
}
