package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Instructor;
import com.example.demo.repository.InstructorJpaRepository;

@Service
public class InstructorService {

	@Autowired
	private InstructorJpaRepository instructorJpaRepository;
	
	public Instructor getInstructorData(Long id) {
		
		Instructor instructor = instructorJpaRepository.getInstructorDataById(id);
		
		return instructor;
	}
	
}
