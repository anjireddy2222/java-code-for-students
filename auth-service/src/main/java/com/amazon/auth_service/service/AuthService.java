package com.amazon.auth_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.auth_service.entity.User;
import com.amazon.auth_service.repository.UserRepositoty;
import com.amazon.auth_service.requests.LoginRequest;
import com.amazon.auth_service.requests.SignupRequest;

@Service
public class AuthService {
	
	@Autowired
	private UserRepositoty userRepositoty;
	
	public User signupUser(SignupRequest signupRequest) {
		
		User newUser = new User();
		newUser.setName( signupRequest.getName() );
		newUser.setEmail( signupRequest.getEmail() );
		newUser.setPassword( signupRequest.getPassword() );
		newUser.setMobile( signupRequest.getMobile() );
		
		
		return userRepositoty.save(newUser);
		
	}
	
	public User loginUser(LoginRequest loginRequest) throws Exception {
		
		Optional<User> dbuserOptional = userRepositoty.findByEmail( loginRequest.getEmail() );
		if(dbuserOptional.isEmpty()) {
			throw new Exception("User not found");
		}
		User user = dbuserOptional.get();
		if( user.getPassword().equals( loginRequest.getPassword() ) == false ) {
			throw new Exception("Invalid login password");
		}
		return user;
		
	}

}
