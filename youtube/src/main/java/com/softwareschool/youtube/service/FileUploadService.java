package com.softwareschool.youtube.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	@Autowired
	public S3UploadService s3UploadService;
	
	public void handlePdfUpload(MultipartFile inpuFile) throws Exception   {
		
		System.out.println( "Inside: handlePdfUpload" );
		
		String fileName = StringUtils.cleanPath( inpuFile.getOriginalFilename() );
		
		String fileExt =	StringUtils.getFilenameExtension(fileName);
		
		System.out.println(fileExt);
		
		if( fileExt.equals("pdf") == false ) {
			throw new Exception(fileExt + " is not allowed. Upload pdfs only.");
		}
		
		System.out.println( inpuFile.getSize() );
		// 1024 * 1024 * 1
		int fileSizeLimit = 1024 * 1024 * 1 ;
		
		if( inpuFile.getSize() > fileSizeLimit  ) {
			throw new Exception("Max 1 MB only.");
		}
		
		String outputFileName = UUID.randomUUID().toString();
		outputFileName = outputFileName + ".pdf";
		System.out.println("outputFilePath: " + outputFileName);
		
		s3UploadService.uploadFile(inpuFile, "pdfs/" + outputFileName);
		
	}
	
}
