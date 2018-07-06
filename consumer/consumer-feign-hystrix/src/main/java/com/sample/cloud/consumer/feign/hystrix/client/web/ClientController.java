package com.sample.cloud.consumer.feign.hystrix.client.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.cloud.consumer.feign.hystrix.client.service.ClientService;

@RestController
@RequestMapping("client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping("service")
	public Object serviceList() {
		
		return clientService.serviceList();
	}

}
