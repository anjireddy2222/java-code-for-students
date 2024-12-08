package com.amazon.orders_service.config;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfiguration {
	
	@Bean
	WebClient webClient(ReactorLoadBalancerExchangeFilterFunction reactorLoadBalancerExchangeFilterFunction ) {
		return WebClient.builder().filter(reactorLoadBalancerExchangeFilterFunction).build();
	}

}
