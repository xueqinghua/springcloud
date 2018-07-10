package com.sample.cloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class Starter {
	
	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
		
	}

}
