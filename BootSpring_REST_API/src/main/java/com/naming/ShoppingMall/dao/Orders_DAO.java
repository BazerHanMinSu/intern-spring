package com.naming.ShoppingMall.dao;

import org.springframework.data.repository.CrudRepository;

import com.naming.ShoppingMall.entities.Orders;

/**
 * 
 * @author naming
 * 1. DAO란? : Data Access Object.
 * 	- DB를 활용해 데이터를 조회하거나 조작하는 기능을 전담하기 위해 존재한다. 
 *
 */

public interface Orders_DAO extends CrudRepository<Orders, Integer> {

}