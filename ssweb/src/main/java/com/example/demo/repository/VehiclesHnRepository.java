package com.example.demo.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Vehicle;

import jakarta.persistence.EntityManager;

@Repository
public class VehiclesHnRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Vehicle> getVehicles(int year){
		return entityManager.createQuery("select v from Vehicle v where v.year=:year and v.brand=:brand", Vehicle.class)
				.setParameter("year", year)
				.setParameter("brand", "Acura")
				.getResultList();
	}

}