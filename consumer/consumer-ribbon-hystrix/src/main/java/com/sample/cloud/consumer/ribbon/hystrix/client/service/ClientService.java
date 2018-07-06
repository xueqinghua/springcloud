package com.sample.cloud.consumer.ribbon.hystrix.client.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ClientService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "fallback")
	public Object clientList() {
		return restTemplate.getForObject("http://provider/provider/client/service",ArrayList.class);
		
	}
	
	
	public Object fallback() {
		return "fallback";
	}

}
