package com.amazon.orders_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.orders_service.dto.OrderRequest;
import com.amazon.orders_service.entity.Order;
import com.amazon.orders_service.service.OrderService;


@RestController
@RequestMapping("/orders/api")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/create-order")
	public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest, @RequestHeader("Authorization") String jwtToken ) throws Exception {
		
		Order order = orderService.createOrder(orderRequest, jwtToken);
		return ResponseEntity.status(HttpStatus.OK).body(order);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleExceptions(Exception ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}

}
