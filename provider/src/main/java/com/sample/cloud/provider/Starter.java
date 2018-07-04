package com.sample.cloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Starter {
	
	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}

}
