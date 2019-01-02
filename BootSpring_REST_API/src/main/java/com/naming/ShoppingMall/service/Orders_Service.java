package com.naming.ShoppingMall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naming.ShoppingMall.dao.Orders_DAO;
import com.naming.ShoppingMall.entities.Orders;

@Service
public class Orders_Service {
	
	@Autowired
	private Orders_DAO ordersDao;
	
	public Orders createOrders(Orders orders) {
		return ordersDao.save(orders);
	}
	
	public Iterable<Orders> getAllOrders() {
		return ordersDao.findAll();
	}
	
	

}
