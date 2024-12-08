package com.amazon.auth_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.auth_service.entity.User;
import com.amazon.auth_service.requests.LoginRequest;
import com.amazon.auth_service.requests.SignupRequest;
import com.amazon.auth_service.service.AuthService;

@RestController
@RequestMapping("/auth/api")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/create-account")
	public ResponseEntity<?> createAccount(@RequestBody SignupRequest signupRequest){
		
		User user = authService.signupUser(signupRequest);
		
		return ResponseEntity.status(HttpStatus.OK).body(signupRequest);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws Exception{
		
		User user = authService.loginUser(loginRequest);
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@GetMapping("/validate-jwt-token")
	public ResponseEntity<?> validateJwtToken(@RequestHeader("Authorization") String jwtToken){
		
		if(jwtToken.length() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(true);
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token is invalid");
		}
		
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}

}
