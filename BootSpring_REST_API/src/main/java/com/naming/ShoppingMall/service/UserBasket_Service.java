package com.naming.ShoppingMall.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.naming.ShoppingMall.dao.UserBasket_DAO;
import com.naming.ShoppingMall.entities.UserBasket;

@Service
public class UserBasket_Service {
	
	@Autowired
	private UserBasket_DAO userbasket_dao;
	
	// 장바구니 저장 기능
	public UserBasket createUserBasket(UserBasket userbasket) {
		return userbasket_dao.save(userbasket);
	}
	
	// 장바구니 검색 기능
	public Optional<UserBasket> getUserBasketById(Integer userbasketID) {
		return userbasket_dao.findById(userbasketID);
	}
	
	// 장바구니 모두 조회
	public Iterable<UserBasket> getAllUserBasket() {
		return userbasket_dao.findAll();
	}
	
	// 장바구니 특정 상품 삭제
	public String deleteUserBasket(Integer userbasketID) {
		String str_check = "delete_sucess";
		try {
			userbasket_dao.deleteById(userbasketID);
		} catch (Exception e) {
			str_check = e.toString();
			return str_check;
		}
		return str_check;
	}
	
	
	// 장바구니 상품 모두 삭제
	public String deleteAll_UserBasket() {
		
		String str_check = "deleteAll_success";
		
		try {
			userbasket_dao.deleteAll();			
		} catch (Exception e) {
			str_check = e.toString();
			return str_check;
		}
		
		return str_check;
		
	}
	
	

}
