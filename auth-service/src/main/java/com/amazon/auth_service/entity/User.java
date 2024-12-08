package com.amazon.auth_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table( name = "users")
public class User {
	
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

}
