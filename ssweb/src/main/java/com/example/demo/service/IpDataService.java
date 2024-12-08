package com.example.demo.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.pojo.IpData;


import jakarta.servlet.http.HttpServletRequest;

@Service
public class IpDataService {
	
	
	
	@Value("${ipinfo.token}")
	public String ipInfoToken;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public IpData getIpDataFromIpInfo(HttpServletRequest request) throws HttpClientErrorException, ResourceAccessException {
			
			/*
			 * Get ip address from request
			 * make API call to 3rd party services
			 */
			String ipAddress = request.getRemoteAddr();
			System.out.println( ipAddress );
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType( MediaType.APPLICATION_JSON );
			
			String inputData = "";
			
			
			HttpEntity<Object> requestEntity = new HttpEntity<>(inputData,  headers );
			
			String apiUrl = "https://ipinfo.io/" + ipAddress + "?" + ipInfoToken;
			System.out.println( apiUrl );
			ResponseEntity<IpData>  response = restTemplate.exchange(apiUrl, HttpMethod.GET, requestEntity, IpData.class );
			IpData ipData = response.getBody();
			return ipData;

		
		
	}
	// 

}
