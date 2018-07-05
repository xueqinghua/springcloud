package com.sample.cloud.provider.property.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("property")
public class PropertyController {
	
	@Autowired
	private Environment environment;
	
	@RequestMapping("/key")
	public Object getProperty(@RequestParam(name="key",required=false) String key) {
		return environment.getProperty(key);
	}

}
