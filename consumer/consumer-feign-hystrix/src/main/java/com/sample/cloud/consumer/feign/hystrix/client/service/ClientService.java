package com.sample.cloud.consumer.feign.hystrix.client.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="provider",fallback = ClientServiceFallback.class)
public interface ClientService {
	
	@RequestMapping("/provider/client/service")
	public Object serviceList();

}
