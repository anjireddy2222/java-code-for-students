package com.amazon.auth_service.requests;

import lombok.Data;

@Data
public class LoginRequest {
	public String email;
	public String password;
}
