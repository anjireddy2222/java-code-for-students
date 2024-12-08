package com.amazon.orders_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.amazon.orders_service.dto.OrderRequest;
import com.amazon.orders_service.entity.Order;
import com.amazon.orders_service.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private WebClient webClient;
	
	public Order createOrder(OrderRequest orderRequest, String jwtToken) throws Exception  {
		
			/*
			 * Path, method, input data, output data
			 * path -> http://localhost:8081/auth/api/validate-jwt-token
			 * input data: header -> Authorization
			 * true or error
			 * method -> GET
			 */
			boolean isTokenValid = webClient
					.get()
					.uri("http://auth-service/auth/api/validate-jwt-token")
					.header("Authorization", jwtToken)
			.retrieve().bodyToMono(Boolean.class).block();
			
			
			
			if(isTokenValid == true) {
				Order order = new Order();
				
				order.setOrderStatus( orderRequest.getOrderStatus() );
				order.setProductId( orderRequest.getProductId() );
				order.setUserId(orderRequest.getUserId());
				order.setPrice(orderRequest.getPrice());
				order.setQuantity(orderRequest.getQuantity());
				
				return orderRepository.save(order);
			}else {
				throw new Exception("You are not authroized to do this action");
			}
			
		
		
		
		
		
	}

}
