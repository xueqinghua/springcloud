package com.sample.cloud.consumer.feign.client.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.cloud.consumer.feign.client.service.ClientService;

@RestController
@RequestMapping("client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
	
	
	@RequestMapping("service")
	public Object clientList() {
		
		LOGGER.info("invoke http://provider/provider/client/service");
		
		return clientService.clientList();
	}

}
