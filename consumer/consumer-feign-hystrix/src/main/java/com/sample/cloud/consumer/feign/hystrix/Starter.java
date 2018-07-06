package com.sample.cloud.consumer.feign.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
public class Starter {
	
	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}

}
