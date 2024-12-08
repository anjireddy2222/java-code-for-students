package com.amazon.orders_service.dto;

import lombok.Data;

@Data
public class OrderRequest {
	private int productId;
	private int userId;
	private double price;
	
	private int quantity;
	private String orderStatus;
}
