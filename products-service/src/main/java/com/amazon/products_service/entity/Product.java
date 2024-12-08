package com.amazon.products_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "products")
@Data
@Entity
public class Product {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int productId;
	
	private String name;
	private String description;
	private double price;
	private int stock;
	private LocalDateTime createdOn = LocalDateTime.now();

}
