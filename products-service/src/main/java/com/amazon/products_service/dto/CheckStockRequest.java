package com.amazon.products_service.dto;

import lombok.Data;

@Data
public class CheckStockRequest {
	
	private int productId;
	private int qunatity;

}
