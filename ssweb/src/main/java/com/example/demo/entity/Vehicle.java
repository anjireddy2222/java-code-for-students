package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.GenerationType;

@Entity
@Data
@Table( name = "vehicles")
public class Vehicle {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int vehicle_id;
	
	private int year;
	private String brand;
	private String model;
	private String trim;
	
}
