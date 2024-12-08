package com.softwareschool.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.softwareschool.youtube.service.FileUploadService;

@RestController
public class FileUploadController {
	
	@Autowired
	public FileUploadService fileUploadService;

	@PostMapping("/upload/pdfs")
	public ResponseEntity<?> uploadPdfs( @RequestParam("pdf_file") MultipartFile inputFile ) throws Exception {
		
		System.out.println("inside method");
		
		fileUploadService.handlePdfUpload(inputFile);
		
		return ResponseEntity.status(HttpStatus.OK).body( inputFile );
		
	}
	
}
