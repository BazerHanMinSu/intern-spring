package com.naming.ShoppingMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naming.ShoppingMall.entities.Orders;
import com.naming.ShoppingMall.service.Orders_Service;

@RestController
@RequestMapping(value="/orders")
public class Orders_Controller {
	
	@Autowired
	private Orders_Service ordersService;
	
	@PostMapping(value="/create")
	public Orders createOrders(@RequestBody Orders orders) {
		return ordersService.createOrders(orders);
	}
	
	@GetMapping(value="/allOrders")
	public Iterable<Orders> getAllOrders(){
		return ordersService.getAllOrders();
	}
	

}
