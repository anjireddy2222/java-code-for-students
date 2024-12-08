package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Instructor;
import com.example.demo.service.InstructorService;
import com.example.demo.utils.ResponseData;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Instructor APIs")
public class InstructorController {
	
	@Autowired
	private InstructorService instructorService;
	
	@GetMapping("instructor/{id}")
	public ResponseEntity<?> getInstructorData(@Parameter(description = "Instructor Id") @PathVariable Long id  ){
		
		Instructor instructor= instructorService.getInstructorData(id);
		Map<String, Object> responsMap = new HashMap<String, Object>();
		responsMap.put(ResponseData.RESULT, ResponseData.SUCCESS);
		responsMap.put(ResponseData.DATA, instructor);
		
		return ResponseEntity.status(HttpStatus.OK).body(responsMap);
	}

}
