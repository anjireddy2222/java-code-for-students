package com.example.demo.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.User;
import com.example.demo.pojo.ForgotPasswordApiData;
import com.example.demo.pojo.IpData;
import com.example.demo.pojo.LoginApiData;
import com.example.demo.pojo.MoneyTransferApiData;
import com.example.demo.pojo.ResetPassword;
import com.example.demo.pojo.SignupApiData;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.AuthService;
import com.example.demo.service.EmailService;
import com.example.demo.service.IpDataService;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.val;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.catalina.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@Tag(name = "Authentication APIs")
@RequestMapping("/auth")
public class AuthController {
	
	/*
		1. api path
		2. receive data -> name, email, password, mobile
		3. validate input data and throw exception
		4. check if user exists with that email -> if yes throw error
		5. create user 
	*/
	
	@Autowired
	public AuthService authService;
	
	@Autowired
	public EmailService emailService;
	
	@Autowired
	private IpDataService ipDataService;
	
	/*
	 * test transactions
	 * money transfer
	 * from account, to account, amount
	 * add account number, balance
	 * 
	 * 
	 */

	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserData(@PathVariable int id){
		User user = authService.getUserData(id);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@PostMapping("/transfer")
	public ResponseEntity<?> transferMoney(@RequestBody MoneyTransferApiData moneyTransferApiData){
		authService.handleMOneyTransfer(moneyTransferApiData);
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("result", "success");
		responseMap.put("data", moneyTransferApiData);
		
		return ResponseEntity.status(HttpStatus.OK).body(responseMap);
	}
	
	
	@PostMapping("/create-account")
	//@Hidden
	public ResponseEntity<ApiResponse<User>> createAccount(@Valid @RequestBody SignupApiData signupApiData) throws Exception {
		
		User userDataObject = authService.handleCreateAccount(signupApiData);
	
		ApiResponse<User> response = new ApiResponse<>("success", "ok", userDataObject);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
		

	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login( @Valid @RequestBody LoginApiData loginApiData, HttpServletRequest request) throws Exception{
		
//		IpData ipData = ipDataService.getIpDataFromIpInfo( request );
		
		Map<String, Object> userData = authService.handleLogin(loginApiData);
		
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("result", "success");
//		responseMap.put("data", userData );
		responseMap.put("ipData", userData );
		
		HttpHeaders headers =  new HttpHeaders();
		headers.add("Authorization", userData.get("token").toString() );
		
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body( responseMap );
	}
	
	/*
	 Forgot password api
	 1. create path
	 2. receive data and validate -> email
	 3. check with db -> if row exists -> send email else throw user not registered error message
	 
	 generate key -> store in db -> send in the link -> receive from UI -> check row based on the key 
	 
	*/
	
	@PostMapping("/forgot-email")
	public ResponseEntity<?> forgotPassword(@Valid @RequestBody ForgotPasswordApiData forgotPasswordApiData) throws Exception{
		
		authService.handleForgotPassword(forgotPasswordApiData);
		
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("result", "success");
		responseMap.put("message", "We have sent an email with a link to rest your password. Please check the spam folder.");
		return ResponseEntity.status(HttpStatus.OK).body(responseMap);
	}
	
	/*
	 * create path
	 * recive and validate data -> linkid, password, confirm password
	 * check if password and confirm password matching -> if yes proceed else throw error
	 * get user based on linkid -> if exists update pasword else invalid reset key or expired
	*/
	
	@PostMapping("rest-password")
	@Operation( description = "Reset user password using email. We will be checking the user id from the users table, if user exists, we will send email with password reset instructions, else return user not found error.", summary = "To reset user password")
	public ResponseEntity<?> resetPassword(@Valid @RequestBody ResetPassword resetPassword) throws Exception{
		authService.handleResetPassword(resetPassword);
		
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("result", "success");
		responseMap.put("message", "Your password updated. Please login.");
		return ResponseEntity.status(HttpStatus.OK).body(responseMap);
	}
	
	
	
	
	@GetMapping("/send-email")
	public ResponseEntity<?> sendEmail() throws Exception{
		String fromEmail = "akkalaanjireddy@gmail.com";
		String toEmail = "akkalaanjireddy@gmail.com";
		String subject = "Test Email Using Gmail SMTP.";
		String mailBody = "Hi Anji, This the test email from Springboot.";
		
//		emailService.sendPlainEmail(fromEmail, toEmail, subject, mailBody);
//		
//		mailBody = "Hi Anji,<br/>" + 
//					"This is the test email from Springboot application. Please use below link to rest your password.<br/>" +
//					"<a href='https://www.softwareschool.co'>Click here</a><br/>" +
//					"<b>Regards,<br/>Anji Reddy</b>";
//		
//		emailService.sendHtmlEmail(fromEmail, toEmail, subject, mailBody);
		
		emailService.sendTemplateEmail(fromEmail, toEmail, subject, "test-email");
		
		Map<String, String> responseMap = new HashMap<String, String>();
		responseMap.put("result", "success");
		responseMap.put("message", "Email sent");
		return ResponseEntity.status(HttpStatus.OK).body(responseMap);
	}
	
	/*
	 1. email, password
	 
	 1. api path
	 2. receive data -> email, password
	 3. database query
	 4. record exists -> login success else invalid login credentials
	 
	*/
	
	// comment text, user_id, video_id, datetime
	// "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
	// "\\d{10}"
	
	
	
	
	
}
