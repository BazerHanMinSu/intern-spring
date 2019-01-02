package com.naming.ShoppingMall.dao;

import org.springframework.data.repository.CrudRepository;
import com.naming.ShoppingMall.entities.Product;


// DAO(Data Access Object)
// DB로부터 입출력을 관리하기 위한 클래스
// 데이터베이스로부터 연산처리가 많을 경우 Connection Pool을 관리하기 위해 존재한다.
public interface ProductDao extends CrudRepository<Product, Integer>{
	
}
