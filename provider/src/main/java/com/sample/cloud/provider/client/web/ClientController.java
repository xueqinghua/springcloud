package com.sample.cloud.provider.client.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class ClientController {
	
	@Autowired
	private DiscoveryClient discoveryClient;
		
	
	@RequestMapping("service")
	public Object clientList() {
		return discoveryClient.getServices();
	}
	
	
	

}
