package com.example.demo.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;



@RestController
public class ImagesController {

	
	@PostMapping("/resize-image")
	public ResponseEntity<?> resizeImages( @RequestParam("inp_file") MultipartFile inpFile) throws IOException{
		
		File tempFile = File.createTempFile("upload_", ".png");
		inpFile.transferTo(tempFile);
		
		Thumbnails.of( tempFile ).size(68, 68).keepAspectRatio(false).toFile("uploads/resized_68x68_2.png");
		
		
		Thumbnails.of( tempFile ).size(100, 100).keepAspectRatio(false).toFile("uploads/resized_100x100_2.png");
		
		
		return ResponseEntity.status(HttpStatus.OK).body("Thumbnail created");
		
	}
	
	@PostMapping("/reduce-size")
	public ResponseEntity<?> reduceImageSize( @RequestParam("inp_file") MultipartFile inpFile) throws IOException{
		
		ByteArrayOutputStream resizedArrayOutputStream = new ByteArrayOutputStream();
		
		Thumbnails.of(inpFile.getInputStream()).scale(1.0).outputQuality(0.3).toOutputStream(resizedArrayOutputStream);
		
		byte[] imageBytes = resizedArrayOutputStream.toByteArray();
		
		File tmpFile = new File("low_quality_img.png");
		
		try( FileOutputStream fileOutputStream = new FileOutputStream(tmpFile) ){
			fileOutputStream.write(imageBytes);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body("Image sized reduced");
		
	}
	
	
	
}
