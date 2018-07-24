package com.sample.cloud.view.thymeleaf.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.cloud.view.thymeleaf.user.entity.User;

@RequestMapping("user")
@Controller
public class UserController {
	
	@RequestMapping("list")
	public String list(ModelMap modelMap) {
		
		List<User> users = new ArrayList<>();
		
		for(int i=0;i<10;i++) {
			User user = new User();
			user.setId(i+"");
			user.setName("name_"+i);
			user.setHeight(i);
			user.setWeight(i);
			user.setAge(i);
			users.add(user);
			
		}
		
		modelMap.addAttribute("userList", users);

		return "user/userList";
	}
	
	
	@RequestMapping("{id}")
	@ResponseBody
	public Object list(@PathVariable String id) {
		
		User user = new User();
		user.setId(id);
		user.setName("name_"+id);
		user.setAge(Integer.valueOf(id));
		

		return user;
	}

}
