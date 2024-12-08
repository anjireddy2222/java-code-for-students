package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

@ControllerAdvice
public class GlobalExceptions {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleApiInputDataValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<String, String>();
		
		ex.getBindingResult().getFieldErrors().forEach( error ->{
			errors.put(error.getField(), error.getDefaultMessage());
		});
		
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("result", "failed");
		responseMap.put("errors", errors);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("result", "failed");
		responseMap.put("message", ex);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<?> handlehttpClientException(HttpClientErrorException ex){
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("result", "failed");
		responseMap.put("message", ex.getMessage());
		return ResponseEntity.status(ex.getStatusCode()).body(responseMap);
	}
	
	@ExceptionHandler(SourceAccountNotFoundException.class)
	public ResponseEntity<?> handleSourceAccountNotFoundException(SourceAccountNotFoundException ex){
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("result", "failed");
		responseMap.put("message", ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
	}
	
	@ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<?> emailNotFoundException(EmailNotFoundException ex){
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("result", "failed");
		responseMap.put("message", ex.getMessage() + ex.getEmail() );
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
	}
	
	

}
