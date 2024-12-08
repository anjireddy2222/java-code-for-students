package com.example.demo.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.DefGenericEquipment;
import com.example.demo.repository.DefGenericEquipmentRespository;
import com.opencsv.CSVReader;

@Service
public class CsvToDbService {
    
	@Autowired
	private CsvToDbBatchProcessService csvToDbBatchProcessService;
    
    public void handleDefGericEquipmentCsvDataUpload(MultipartFile inputCsvFile ) throws Exception {
        String fileName = StringUtils.cleanPath(inputCsvFile.getOriginalFilename());
        String fileExtension = StringUtils.getFilenameExtension(fileName);

        if (!"csv".equalsIgnoreCase(fileExtension)) {
            throw new Exception("Please upload a CSV file.");
        }

//        try (Reader reader = new BufferedReader(new InputStreamReader(inputCsvFile.getInputStream()));
//             CSVReader csvReader = new CSVReader(reader)) {
//
//            String[] csvRow = csvReader.readNext(); // Skip header
//            csvRow = csvReader.readNext(); // Read first data row
//            List<DefGenericEquipment> defObjectsList = new ArrayList<>();
//            
//            System.out.println( "Inside handleDefGericEquipmentCsvDataUpload: " +  Thread.currentThread().getName() );
//            while (csvRow != null) {
//                DefGenericEquipment defObj = new DefGenericEquipment();
//                defObj.setGenericEquipmentId(Integer.parseInt(csvRow[0]));
//                defObj.setEquipmentCategoryId(Integer.parseInt(csvRow[1]));
//                defObj.setGenericEquipmentName(csvRow[2]);
//                defObj.setGenericEquipmentValue(csvRow[3]);
//                
//                defObjectsList.add(defObj);
//
//                if (defObjectsList.size() == 1000) {
//                	csvToDbBatchProcessService.processBatchUpload( new ArrayList<>(defObjectsList) );
//                    defObjectsList.clear();
//                }
//
//                csvRow = csvReader.readNext();
//            }
//
//            if (!defObjectsList.isEmpty()) {
//            	csvToDbBatchProcessService.processBatchUpload(defObjectsList);
//            	defObjectsList.clear();
//            }
//
//        } catch (Exception e) {
//            throw new Exception("Unable to upload CSV data", e);
//        }
    }
    /*
     * thread 1
     * 1st 1000
     * parallel 1000 loop
     * thread 2 
     * 2nd 1000
     * parallel 1000 loop
     *  thread 3
     * 3rd 1000
     */
    
    
    // 100,000
    // loop 1000 times
    // 1 -> 1000
    // loop 1000 times
    // 2 -> 1000 
    // loop 1000 times
    // 3 -> 1000
    
    // 100,000
    // loop 1000 times // 1 -> 1000 // loop 1000 times // 1 -> 1000
    
    
    
    
}
