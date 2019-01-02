package com.naming.ShoppingMall.dao;

import org.springframework.data.repository.CrudRepository;

import com.naming.ShoppingMall.entities.Orders;

public interface Orders_DAO extends CrudRepository<Orders, Integer> {

}