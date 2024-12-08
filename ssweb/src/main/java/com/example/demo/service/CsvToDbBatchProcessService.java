package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DefGenericEquipment;
import com.example.demo.repository.DefGenericEquipmentRespository;

@Service
public class CsvToDbBatchProcessService {
	
	@Autowired
	private DefGenericEquipmentRespository defGenericEquipmentRespository;
	
	@Async("imageAsyncConfig")
    public void processBatchUpload(List<DefGenericEquipment> defObjectsList) {
    	try {
    		System.out.println( "Inside processBatchUpload: " + Thread.currentThread().getName() );
        	defGenericEquipmentRespository.saveAll(defObjectsList);
		} catch (Exception e) {
			System.out.println( "Inside Exception: " +  e.getMessage() );
			System.out.println( "Inside Exception: " +  defObjectsList );
		}
    }
	
}
