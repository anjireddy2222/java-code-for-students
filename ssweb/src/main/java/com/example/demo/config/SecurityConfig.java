package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.filter.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	/*
	 * public apis -< can access without token
	 * secured apis -> with token
	 * role based -> ADMIN, Student
	 */
	@Autowired
	public JwtRequestFilter jwtRequestFilter;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
		.csrf( csrf -> csrf.disable() )
		.authorizeHttpRequests( auth -> 
		
			auth
//			.requestMatchers("/login").permitAll()
//			.requestMatchers("/create-account").permitAll()
			.requestMatchers("/auth/**").permitAll()
			.requestMatchers("/actuator/**").permitAll()
			.requestMatchers("/student/**").hasRole("STUDENT")
			.requestMatchers("/admin/**").hasRole("ADMIN")
			.anyRequest().authenticated()
				
		)
		.sessionManagement( session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		);
		
		http.addFilterBefore( jwtRequestFilter, UsernamePasswordAuthenticationFilter.class );
		
		return http.build();
	}
	

}
