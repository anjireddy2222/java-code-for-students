package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table( name = "users" )
@Data
public class User {

	// user_id, name, email, password, mobile, created_on, is_active, is_email_verified
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column( name = "user_id")
	private int id;
	
	private String name;
	private String email;
	
//	@Column(name = "email_id")
	private String emailId;
	private String password;
	private String mobile;
	private String passwordResetKey;
	
	private LocalDateTime createdOn = LocalDateTime.now();
	private Boolean isActive = true;
	private Boolean isEmailVerified = false;
	
	private String accountNumber;
	private Double balance;
}
