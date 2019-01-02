package com.naming.ShoppingMall.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naming.ShoppingMall.entities.UserBasket;
import com.naming.ShoppingMall.service.UserBasket_Service;

@RestController
@RequestMapping(value="/userbaskets")

public class UserBasket_Controller {
	
	@Autowired
	private UserBasket_Service userbasket_Service;
	
	
	// 장바구니에 데이터를 저장하기 위한 URL
	@PostMapping(value="/create")
	public UserBasket createUserBasket(@RequestBody UserBasket userbasket) {
		return userbasket_Service.createUserBasket(userbasket);
	}
	
	// 장바구니 상품 조회
	@GetMapping(value="/{userbasketID}")
	public Optional<UserBasket> getProductById(@PathVariable("userbasketID")Integer userbasketID){
		return userbasket_Service.getUserBasketById(userbasketID);
	}
	
	
	// 장바구니 상품 선택 삭제 URL
	@DeleteMapping(value="/delete/{userbasketID}")
	public void deleteUserBasket(@PathVariable("userbasketID")Integer userbasketID) {
		userbasket_Service.deleteUserBasket(userbasketID);
	}
	
	// 장바구니 상품 모두 삭제 URL
	@DeleteMapping(value="/deleteAll")
	public void deleteAll() {
		userbasket_Service.deleteAll_UserBasket();
	}
	


}
