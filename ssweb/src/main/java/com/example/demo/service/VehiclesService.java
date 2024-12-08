package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Vehicle;
import com.example.demo.pojo.VehiclesSearchApiData;
import com.example.demo.repository.VehiclesHnRepository;
import com.example.demo.repository.VehiclesJdbcRespository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class VehiclesService {
	
	@Autowired
	private VehiclesJdbcRespository vehiclesJdbcRespository;
	
	@Autowired
	private VehiclesHnRepository vehiclesHnRepository;
	
	
	public List<Vehicle> handleVehiclesSearch( VehiclesSearchApiData vehiclesSearchApiData ) {
		
		List<Vehicle> vehicles = vehiclesHnRepository.getVehicles( vehiclesSearchApiData.getYear() );
		System.out.println("begin");
		System.out.println(vehicles);
		System.out.println("end");
		
		
		
		return vehiclesJdbcRespository.dbVehiclesSearch(vehiclesSearchApiData.getYear(), vehiclesSearchApiData.getBrand(), vehiclesSearchApiData.getModel());
		
	}

}
