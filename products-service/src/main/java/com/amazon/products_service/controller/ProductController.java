package com.amazon.products_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.products_service.dto.CheckStockRequest;
import com.amazon.products_service.entity.Product;
import com.amazon.products_service.service.ProductService;

@RestController
@RequestMapping("/products/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/check-stock")
	public ResponseEntity<?> checkStock(@RequestBody CheckStockRequest checkStockRequest) throws Exception{
		
		Product product = productService.checkStock(checkStockRequest);
		return ResponseEntity.status(HttpStatus.OK).body(product);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
	

}
