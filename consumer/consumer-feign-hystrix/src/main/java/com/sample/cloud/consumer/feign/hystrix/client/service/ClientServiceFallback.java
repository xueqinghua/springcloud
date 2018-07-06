package com.sample.cloud.consumer.feign.hystrix.client.service;

import org.springframework.stereotype.Service;

@Service
public class ClientServiceFallback  implements ClientService {

	@Override
	public Object serviceList() {
		// TODO Auto-generated method stub
		return "fallback";
	}
}
