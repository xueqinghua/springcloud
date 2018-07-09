package com.sample.cloud.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Starter {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(Starter.class).web(true).run(args);
	}

}
