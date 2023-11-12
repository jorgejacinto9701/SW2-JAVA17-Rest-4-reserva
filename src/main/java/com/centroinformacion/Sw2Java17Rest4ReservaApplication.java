package com.centroinformacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Sw2Java17Rest4ReservaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sw2Java17Rest4ReservaApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
