package com.sample.cloud.consumer.base.client.web;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("client")
public class ClientController {
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
	
	
	@RequestMapping("service")
	public Object clientList() {
		
		ServiceInstance serviceInstance = loadBalancerClient.choose("provider");
		
		String url = serviceInstance.getUri()+"/provider/client/service";
		
		LOGGER.info(serviceInstance.getUri().toString());
		
		return restTemplate.getForObject(url,ArrayList.class);
	} 

}
