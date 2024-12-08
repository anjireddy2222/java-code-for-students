package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.pojo.LoginApiData;
import com.example.demo.service.AuthService;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AuthService authService;
	
	@Test
	public void testEmailRequiredLogin() throws Exception {
		
		mockMvc.perform(
				post("/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"email\": \"12345678\"}")
			)
		.andExpect( status().isBadRequest() )
		.andExpect( jsonPath("$.errors.email").value("Email required") );
		
	}
	
	@Test
	public void testPasswordRequired() throws Exception {
		mockMvc.perform(
				post("/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"password\": \"contact@softwareschool.co\"}")
				).andExpect( status().isBadRequest())
		.andExpect( jsonPath("$.errors.password").value("Password is required") );
		
	}
	
	@Test
	public void testEmailPasswordBothRequiredLogin() throws Exception {
		mockMvc.perform(
				post("/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{}")
		)
		.andExpect( status().isBadRequest())
		.andExpect( jsonPath("$.errors.password").value("Password is required") )
		.andExpect( jsonPath("$.errors.email").value("Email required") );
	}
	
	@Test
	public void testLoginSuccess() throws Exception {
		
		LoginApiData mockLoginApiData = new LoginApiData();
		mockLoginApiData.setEmail("contact@softwareschool.co");
		mockLoginApiData.setPassword("12345678");
		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("token", "gagagagaaa");
		response.put("userData", "");
		
		Mockito.when( authService.handleLogin(mockLoginApiData) ).thenReturn(response);
		
		mockMvc.perform( 
				post("/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"email\": \"contact@softwareschool.co\", \"password\": \"12345678\"}")
		)
		.andExpect( status().isOk() );

	}
	
	@Test
	public void testEmailNotRegisteredLogin() throws Exception {
		
		LoginApiData mockLoginApiData = new LoginApiData();
		mockLoginApiData.setEmail("contact@softwareschool.co");
		mockLoginApiData.setPassword("12345678");
		
		Mockito.when( authService.handleLogin(mockLoginApiData) ).thenThrow(new Exception("Email is not registered with us. Please signup."));
		
		mockMvc.perform( 
				post("/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"email\": \"contact@softwareschool.co\", \"password\": \"12345678\"}")
		)
		.andExpect( status().isBadRequest() )
		.andExpect(jsonPath("$.message").value("Email is not registered with us. Please signup."));

	}
	
	@Test
	public void testpasswordNotMatchingLogin() throws Exception {
		
		LoginApiData mockLoginApiData = new LoginApiData();
		mockLoginApiData.setEmail("contact@softwareschool.co");
		mockLoginApiData.setPassword("12345678");
		
		Mockito.when( authService.handleLogin(mockLoginApiData) ).thenThrow(new Exception("Password is not matching, Please try again."));
		
		mockMvc.perform( 
				post("/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"email\": \"contact@softwareschool.co\", \"password\": \"12345678\"}")
		)
		.andExpect( status().isBadRequest() )
		.andExpect(jsonPath("$.message").value("Password is not matching, Please try again."));

	}
	
	

}
