package com.sample.cloud.zuul.common.configuration;

import org.springframework.context.annotation.Bean;

import com.sample.cloud.zuul.common.filter.AccessZuulFilter;

@org.springframework.context.annotation.Configuration
public class Configuration {
	
	@Bean
	public AccessZuulFilter accessZuulFilter() {
		return new AccessZuulFilter();
	}

}
