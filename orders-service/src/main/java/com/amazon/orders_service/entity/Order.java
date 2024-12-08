package com.amazon.orders_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column( name = "order_id")
	private int id;
	
	private int productId;
	private int userId;
	private double price;
	
	private int quantity;
	private String orderStatus;
	
	private LocalDateTime createdOn = LocalDateTime.now();
	

}
