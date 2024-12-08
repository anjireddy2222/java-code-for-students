package com.softwareschool.youtube.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

@Service
public class S3UploadService {


	public S3Client s3Client;
	
	public S3UploadService() {
		
		AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create("", "");
		s3Client = S3Client.builder().region( Region.of("ap-south-1") ).credentialsProvider( StaticCredentialsProvider.create(awsBasicCredentials) ).build();
		
	}
	
	public void uploadFile( MultipartFile inpuFile, String fileName ) throws Exception {
		// request object
		// call putobject method
		
		PutObjectRequest request = PutObjectRequest.builder().bucket("youtube-classes-ss-co").key(fileName).build();
		s3Client.putObject( request, RequestBody.fromInputStream( inpuFile.getInputStream()  , inpuFile.getSize()) );
		
	}
	
}
