package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.CsvToDbService;
import com.example.demo.service.FileUploadService;
import com.example.demo.service.JwtService;

import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/upload")
@Tag(name = "File upload APIs")
public class FileUploadController {

	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired
	private JwtService jwtService;
	
	/*
	 * Create entity ( it will create table in the database ) 
	 * Create repository 
	 * create end point
	 * Create service
	 * 
	 */
	@Autowired
	private CsvToDbService csvToDbService;
	
	@PostMapping("/csvToDb")
	public ResponseEntity<?> uploadCsvToDb( @RequestParam("csv_file") MultipartFile inputCsvFile) throws Exception{
		
		csvToDbService.handleDefGericEquipmentCsvDataUpload(inputCsvFile);
		
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("result", "success");
		responseMap.put("message", "csv file imported to db successfully.");
		
		return ResponseEntity.status(HttpStatus.OK).body(responseMap);
	}
	
	

	/*
	 * After Login
	 * Receive Authorization header
	 * Check if it is null
	 * Check if it start with Bearer
	 * Get token without Bearer
	 * Check it is valid or not
	 * Check if it is expired or not
	 * if all are ok, proceed to operation else throw error
	 */
	
	@PostMapping("/images")
	public ResponseEntity<?> uploadImages(@RequestHeader("Authorization") String jwtToken, @RequestParam("profile_pic") MultipartFile inputFile ) throws Exception{
		
		System.out.println( jwtToken );
		
		if( jwtToken == null || jwtToken.startsWith("Bearer") == false ) {
			throw new Exception("Unautorized. You are not allowed to do this operation.");
		}
		
		jwtToken = jwtToken.substring( 7 );
		
		System.out.println( jwtToken );
		
		Boolean isTokeValid = jwtService.verifyJwtToken(jwtToken);
		System.out.println( isTokeValid );
		
		Claims claims =  jwtService.getJwtClaims(jwtToken);
		System.out.println(claims.get("id"));
		
		System.out.println(claims.get("email"));
		
		fileUploadService.handleImageUpload(inputFile);
		
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("result", "success");
		responseMap.put("message", "image uploaded successfully.");
		
		return ResponseEntity.status(HttpStatus.OK).body(responseMap);
		
	}
	
	@PostMapping("/pdfs")
	public ResponseEntity<?> uploadPdfs(@RequestParam("pdf_file") MultipartFile inputFile ) throws Exception{
		
		fileUploadService.handlePdfUpload(inputFile);
		
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("result", "success");
		responseMap.put("message", "PDF uploaded successfully.");
		
		return ResponseEntity.status(HttpStatus.OK).body(responseMap);
	}
	
	
}
