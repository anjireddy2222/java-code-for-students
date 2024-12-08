package com.amazon.products_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.products_service.dto.CheckStockRequest;
import com.amazon.products_service.entity.Product;
import com.amazon.products_service.repository.ProductRepository;

@Service
public class ProductService {
	
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public Product checkStock(CheckStockRequest checkStockRequest) throws Exception {
		
		Optional<Product> dbDataOptional = productRepository.findById(checkStockRequest.getProductId());
		if(dbDataOptional.isEmpty()) {
			throw new Exception("Product id is invalid");
		}
		
		Product product = dbDataOptional.get();
		
		if( checkStockRequest.getQunatity() > product.getStock() ) {
			throw new Exception("Product is out od stock");
		}
		
		return product;
		
	}

}
