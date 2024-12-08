package com.example.demo.service;

//import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;

import org.apache.coyote.http11.InputFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	/*
	 * get file type (extension)
	 * check if it is in allowed file types -> if yes ok else throw error
	 * check file size -> if it is under allowed size ok else throw error  ( Bytes )
	 * generate unique file name
	 * upload to folder
	 * resize images
	 * reduce image size without loosing quality
	 */
	
	@Value("${file.upload.images.path}")
	private String IMAGE_UPLOAD_PATH;
	
	@Value("${file.upload.pdf.path}")
	private String PDF_UPLOAD_PATH;
	
	@Autowired
	private S3FileService s3FileService;
	
	
	
	private int MAX_ALLOWED_IMAGE_SIZE = 5 * 1024 * 1024;
	
	private int MAX_ALLOWED_PDF_SIZE = 10 * 1024 * 1024;
	
	public void handleImageUpload(MultipartFile inpuFile) throws Exception {
		/*
		 * Create API end point
		 * Get file type and check if it is allowed or not
		 * get file size and check if it is under allowed limit
		 * generate unique file name
		 * call AWS s3 put object method
		 */
		
		String fileName = StringUtils.cleanPath(inpuFile.getOriginalFilename() );
		String fileType = StringUtils.getFilenameExtension( fileName );
		
		String[] allowedFileTypes = {"png", "jpg", "gif", "jpeg"};
		Boolean isFileTypeAllowed = Arrays.stream( allowedFileTypes ).anyMatch( fileType::equals  );
		
		if( isFileTypeAllowed == false) {
			throw new Exception( fileType + " file is not allowed");
		}
		
		
		if( inpuFile.getSize() > MAX_ALLOWED_IMAGE_SIZE ) {
			throw new Exception( "Max 5MB allowed" );
		}
		
		String uploadImageName = UUID.randomUUID().toString() + "." + fileType;
		
		// s3FileService.uploadFileToS3(inpuFile, "images/" + uploadImageName);
		
		
		
	}
	
	
	public void handlePdfUpload(MultipartFile inputFile) throws Exception {
		
		String fileName = StringUtils.cleanPath( inputFile.getOriginalFilename() );
		String fileType = StringUtils.getFilenameExtension( fileName );
		
		if( fileType.equals( "pdf" ) == false ) {
			throw new Exception(fileType + " file is not allowed");
		}
		
		if( inputFile.getSize() > MAX_ALLOWED_PDF_SIZE ) {
			throw new Exception( "Max 10MB allowed" );
		}
		
		String uploadPdfFileName = UUID.randomUUID().toString() + ".pdf";
		
		Path uploadPath = Paths.get( PDF_UPLOAD_PATH + uploadPdfFileName );
		System.out.println(uploadPath);
		
//		Files.copy( inputFile.getInputStream(), uploadPath);
		
		s3FileService.uploadFileToS3(inputFile, "pdfs/" + uploadPdfFileName);
		
		
		
	}
	
	
	
	
	
	
	
}
