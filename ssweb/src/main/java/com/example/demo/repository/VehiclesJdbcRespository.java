package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Vehicle;
import com.example.demo.pojo.VehiclesSearchApiData;

@Repository
public class VehiclesJdbcRespository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	static class VehicleRowMapper implements RowMapper<Vehicle>{
		
		@Override
		public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Vehicle vehicle = new Vehicle();
			
			vehicle.setBrand( rs.getString("brand") );
			vehicle.setModel( rs.getString("model") );
			vehicle.setVehicle_id( rs.getInt("vehicle_id") );
			vehicle.setYear( rs.getInt("year") );
			vehicle.setTrim( rs.getString("trim") );
			
			return vehicle;
		}
		
	}

	
	public List<Vehicle> dbVehiclesSearch( int year, String brand, String model ) {
		
		
		StringBuilder sqlQueryBuilder = new StringBuilder("select * from vehicles where");
		System.out.println( sqlQueryBuilder.toString() );
		
		List<Object> paramsList = new ArrayList<Object>();
		
		int noOfConditions = 0;
		
		if( year != 0 ) {
			noOfConditions = noOfConditions + 1;
			sqlQueryBuilder.append(" year= ?"  );
			paramsList.add(year);
		}
		System.out.println( sqlQueryBuilder.toString() );
		
		if( brand !=null ) {
			if( noOfConditions == 0 ) {
				sqlQueryBuilder.append(" brand= ?");
			}else {
				sqlQueryBuilder.append(" and brand= ?" );
			}
			noOfConditions = noOfConditions + 1;
			paramsList.add(brand);
		}
		
		if( model !=null ) {
			if( noOfConditions == 0) {
				sqlQueryBuilder.append(" model= ?");
			}else {
				sqlQueryBuilder.append(" and model= ?");
			}
			noOfConditions = noOfConditions + 1;
			paramsList.add(model);
		}
		System.out.println( "noOfConditions: " + noOfConditions );
		System.out.println( sqlQueryBuilder.toString() );
		System.out.println(paramsList);
		
		
		List<Vehicle> vehicles =  jdbcTemplate.query( sqlQueryBuilder.toString() , paramsList.toArray(), new VehicleRowMapper());
		System.out.println( vehicles );
		return vehicles;
		
	}
	
}
