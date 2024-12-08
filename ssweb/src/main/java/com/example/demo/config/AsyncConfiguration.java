package com.example.demo.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfiguration {
	
	@Bean("csvAsyncConfig")
	public Executor asyncCsvTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(15);
		executor.setMaxPoolSize(100);
		executor.setQueueCapacity(5);
		executor.setThreadNamePrefix("csvAsyncprocessor-");
		executor.initialize();
		return executor;
	}
	
	@Bean("imageAsyncConfig")
	public Executor asyncImagesTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(20);
		executor.setQueueCapacity(5);
		executor.setThreadNamePrefix("imageAsyncprocessor-");
		executor.initialize();
		return executor;
	}
	
	
	/*
	 * 15 threads
	 * 15 jobs -> running
	 * 10 
	 * 16th task -1
	 * task -2
	 * 
	 */

}
