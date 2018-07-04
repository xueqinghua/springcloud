package com.sample.cloud.consumer.feign.client.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="provider",path="provider")

public interface ClientService {
	
	@RequestMapping("client/service")
	public Object clientList();

}
