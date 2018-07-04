package com.sample.cloud.consumer.ribbon.client.web;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("client")
public class ClientController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
	
	@RequestMapping("service")
	public Object clientList() {
		
		LOGGER.info("invoke http://provider/provider/client/service");
		
		return restTemplate.getForObject("http://provider/provider/client/service", ArrayList.class);
	}
	

}
