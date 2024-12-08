package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.tomcat.util.buf.UEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.exception.EmailNotFoundException;
import com.example.demo.exception.SourceAccountNotFoundException;
import com.example.demo.pojo.ForgotPasswordApiData;
import com.example.demo.pojo.LoginApiData;
import com.example.demo.pojo.MoneyTransferApiData;
import com.example.demo.pojo.ResetPassword;
import com.example.demo.pojo.SignupApiData;
import com.example.demo.repository.UserRespository;

import io.jsonwebtoken.Claims;


@Service
public class AuthService {

	@Autowired
	public UserRespository userRespository;
	
	@Autowired
	public EmailService emailService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	public Logger logger = LoggerFactory.getLogger( AuthService.class );
	
	public PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	
	public User getUserData(int id) {
		User user = (User) redisTemplate.opsForValue().get("USER_" + id);
		System.out.println(user);
		if(user == null) {
			System.out.println("Getting data from Db");
			Optional<User> optData = userRespository.findById(id);
			if(optData.isEmpty() == false) {
				user = optData.get();
				redisTemplate.opsForValue().set("USER_" + id, user);
			}
		}
		
		return user;
	}
	
	
	@Transactional
	public void handleMOneyTransfer(MoneyTransferApiData moneyTransferApiData) {
		/*
		 * input -> from, to, amount
		 * get from account, update balance (balance - amount)
		 * get to account, update balance (balance  + amount)
		 */
		Optional<User> userOptional = userRespository.findByAccountNumber(moneyTransferApiData.getFromAccount());
		if( userOptional.isEmpty() ) {
			throw new SourceAccountNotFoundException("Source account not found.");
		}
		
		User fromUser = userOptional.get();
		Double balance = fromUser.getBalance() - moneyTransferApiData.getAmount();
		fromUser.setBalance(balance);
		userRespository.save(fromUser);
		
		userOptional = userRespository.findByAccountNumber(moneyTransferApiData.getToAccount());
		if(userOptional.isEmpty()) {
			throw new RuntimeException("Destination account not found");
		}
		
		User toUser = userOptional.get();
		balance = toUser.getBalance() + moneyTransferApiData.getAmount();
		toUser.setBalance(balance);
		userRespository.save(toUser);
		
		
	}
	
	
	public User handleCreateAccount(SignupApiData signupApiData) throws Exception {
		
		Optional<User> dbData = userRespository.findByEmail( signupApiData.getEmail() );
		
		if( dbData.isEmpty() ) {
			User userObj = new User();
			
			userObj.setName( signupApiData.getName() );
			userObj.setEmail( signupApiData.getEmail() );
			userObj.setPassword( passwordEncoder.encode( signupApiData.getPassword() ) );
			userObj.setMobile( signupApiData.getMobile());
			
			User dbUserData = userRespository.save( userObj );
			logger.info("Account created: email={}", signupApiData.getEmail());
			return dbUserData;
		}else {
			logger.error("Account creation failed: email={}", signupApiData.getEmail());
			throw new Exception("User already exists. Please login");
		}
		
	}
	
	public Map<String, Object> handleLogin(LoginApiData loginApiData)  {
		/*
		 1. get record by email -> if exists -> check password else throw email is not registed with us
		 2. if password matching -> login success and send user data else throw invalid password
		*/
		Optional<User> dbData = userRespository.findByEmail( loginApiData.getEmail() );
		
		if( dbData.isEmpty() ) {
			logger.error("Login failed: email={}, reason=Email is not registered", loginApiData.getEmail());
			throw new EmailNotFoundException("Email is not registered with us. Please signup.", loginApiData.getEmail());
		}else {
			User userData = dbData.get();
			Boolean isMatching = passwordEncoder.matches(loginApiData.getPassword(), userData.getPassword());
			if( isMatching == true ) {
				String jwtToken = jwtService.generateJwtToken(userData);
				Map<String, Object> response = new HashMap<String, Object>();
				response.put("token", jwtToken);
				response.put("userData", userData);
				logger.info("Login success: email={}", loginApiData.getEmail());
				return response;
			}else {
				logger.error("Login failed: email={}, reason=Password is not matching", loginApiData.getEmail());
				throw new RuntimeException("Password is not matching, Please try again.");
			}
		}
		
	}
	
	public void handleForgotPassword(ForgotPasswordApiData forgotPasswordApiData) throws Exception{
		
		Optional<User> dbData = userRespository.findByEmail( forgotPasswordApiData.getEmail() );
		
		if( dbData.isEmpty() ) {
			throw new Exception("Email id not registered with us. Please check your email and try again.");
		}
		
		System.out.println(dbData.get());
		String passwordResetKey = UUID.randomUUID().toString();
		User userData = dbData.get();
		userData.setPasswordResetKey(passwordResetKey);
		userRespository.save(userData);
		String mailBody = "Hi " + userData.getName() + ", " +
				"Please find the below link to reset your password. <br/>" + 
				"Password reset link: <a href='http://localhost:8080/pasword-rest-ui?linkid=" + passwordResetKey +"' >click here</a><br/>" + 
				"<b>Regards<br/>Springbbot App</b>";
		
		emailService.sendHtmlEmail("akkalaanjireddy@gmail.com", userData.getEmail(), "Password reset Link", mailBody);
	
		
	}
	
	public void handleResetPassword(ResetPassword resetPassword) throws Exception {
		
		if( resetPassword.getPassword().equals( resetPassword.getConfirmPassword() ) == false ) {
			throw new Exception("Password and Confirm passwords should match.");
		}
		
		Optional<User> dbData = userRespository.findByPasswordResetKey( resetPassword.getLinkId() );
		
		if(dbData.isEmpty()) {
			throw new Exception("Invalid password reset key or expired.");
		}
		
		System.out.println( dbData.get() );
		User userData = dbData.get();
		userData.setPassword( passwordEncoder.encode( resetPassword.getPassword()  ) );
		userData.setPasswordResetKey("");
		
		userRespository.save(userData);
		
	}
	
	

}
