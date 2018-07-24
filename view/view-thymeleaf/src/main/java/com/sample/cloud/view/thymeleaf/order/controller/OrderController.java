package com.sample.cloud.view.thymeleaf.order.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.cloud.view.thymeleaf.order.entity.Order;


@Controller
@RequestMapping("order")
public class OrderController {
	
	
	public String list(ModelMap modelMap) {
		
		List<Order> orders = new ArrayList<>();
		
		for(int i=0;i<10;i++) {
			Order order = new Order();
			order.setId(i+"");
			order.setAmount(Long.valueOf(i));
			order.setCreateDate(new Date());
			orders.add(order);
		}
		
		modelMap.addAttribute("orderList", orders);
		
		
		return "order/orderList";
	}
	
	@RequestMapping("{id}")
	public Object get(@PathVariable String id) {
		Order order = new Order();
		order.setId(id);
		order.setAmount(Long.valueOf(id));
		order.setCreateDate(new Date());
		
		return order;
		
	}
}
