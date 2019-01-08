package com.naming.ShoppingMall.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	// 구매리스트 상품 추가
	@PostMapping
	public Orders createOrders(@RequestBody Orders orders) {
		return ordersService.createOrders(orders);
	}

	// 구매리스트 전체상품 조회 URL
	@GetMapping
	public Iterable<Orders> getAllOrders(){
		return ordersService.getAllOrders();
	}
	
	// 구매리스트 특정상품 조회 URL
	@GetMapping(value="/{ordersId}")
	public Optional<Orders> getOrdersById(@PathVariable("ordersId")Integer ordersId) {
		return ordersService.getOrdersById(ordersId);
	}
	

}
