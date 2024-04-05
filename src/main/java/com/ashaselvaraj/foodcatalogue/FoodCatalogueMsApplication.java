package com.ashaselvaraj.foodcatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FoodCatalogueMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodCatalogueMsApplication.class, args);
	}

	@Bean
	@LoadBalanced //Eureka finds the available	 instance of the MS and fetch details
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
