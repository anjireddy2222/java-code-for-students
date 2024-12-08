package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	
	// plain text
	// html emails -> design
	// from email, to email, subject, body
	
	@Autowired
	public JavaMailSender javaMailSender;
	
	
	
	
	public void sendPlainEmail(String fromEmail, String toEmail, String subject, String mailBody) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom(fromEmail);
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(mailBody);
		
		
		javaMailSender.send(message);
		
	}
	
	public void sendHtmlEmail(String fromEmail, String toEmail, String subject, String mailBody) throws Exception {
		
		MimeMessage message =  javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		helper.setFrom(fromEmail);
		helper.setTo(toEmail);
		helper.setSubject(subject);
		helper.setText(mailBody, true);
		
		javaMailSender.send(message);
		
	}
	/*
	 * Create html files
	 * Use thymeleaf -> html to string
	 * compose html email and send
	 */
	
	@Autowired
	public TemplateEngine templateEngine;
	
	public void sendTemplateEmail(String fromEmail, String toEmail, String subject, String fileName) throws Exception {
		
		Context context = new Context();
		
		String mailBody = templateEngine.process(fileName, context);
		
		MimeMessage message =  javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		helper.setFrom(fromEmail);
		helper.setTo(toEmail);
		helper.setSubject(subject);
		helper.setText(mailBody, true);
		
		javaMailSender.send(message);
	}
	
	
	

}
