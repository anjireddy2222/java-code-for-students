package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Vehicle;
import com.example.demo.pojo.VehiclesSearchApiData;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.VehiclesService;
import com.example.demo.utils.ResponseData;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag( name = "Vehicle APIs")
public class VehiclesController {
	
	@Autowired
	private VehiclesService vehiclesService;
	
	@PostMapping("/student/search")
	public ResponseEntity<?> searchvehicles(@RequestBody VehiclesSearchApiData vehiclesSearchApiData){
		
		List<Vehicle> vehicles = vehiclesService.handleVehiclesSearch(vehiclesSearchApiData);
	
		ApiResponse<List<Vehicle>> response = new ApiResponse<List<Vehicle>>("success", "ok", vehicles);
		
		return ResponseEntity.status(HttpStatus.OK).body( response );
		
	}

}
