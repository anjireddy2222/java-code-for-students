package com.amazon.auth_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazon.auth_service.entity.User;

@Repository
public interface UserRepositoty extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
	
}
