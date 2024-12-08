package com.example.demo.scheduler;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.service.S3FileService;

@Component
public class SimpleScheduler {

	@Autowired
	private S3FileService s3FileService;
	
	@Scheduled( fixedRate = 500000000 )
	public void printSomeData() {
		System.out.println( "Running from scheduler" );
	}
	
	// cron - "sec(0 -59) min(0 - 59) hours( 0 to 23) date(0-30) month(0-11) week-day(SUN, MON)"
	
	@Scheduled( fixedRate = 100000000)
	public void uploadLogsToS3() throws Exception {
		/*
		 * logs directory
		 * get all files from log folder
		 * loop -> upload each file
		 */
//		System.out.println("uploading logs to AWS s3");
//		String logsFolder = System.getProperty("user.dir") + "/logs";
//		File logsDirectory = new File(logsFolder);
//		
//		File[] logFiles = logsDirectory.listFiles();
//		for(File logFile: logFiles) {
//			s3FileService.uploadLogFilesToS3(logFile, "logs/" + logFile.getName());
//			System.out.println("Uploaded: logs/" + logFile.getName());
//		}
	}
	
	
	
}
