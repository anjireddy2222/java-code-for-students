package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;
import java.util.List;


public interface UserRespository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
	
	Optional<User> findByPasswordResetKey(String passwordResetKey);
	
	Optional<User> findByAccountNumber(String accountNumber);
	// select * from users where account_number = accountNumber;
	
	Optional<User> findByEmailId(String email_id);
	
}
