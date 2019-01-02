package com.naming.ShoppingMall.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="userbasket")
public class UserBasket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userbasketID")
	private Integer userbasketID;
	
	@Column(name="ProductID")
	private Integer productID;
	
	
	public Integer getUserBasketID() {
		return userbasketID;
	}
	public void setUserBasketID(Integer userbasketID) {
		this.userbasketID = userbasketID;
	}
	
	
	public Integer getUserBasket_ProductID() {
		return productID;
	}
	public void setUserBasket_ProductID(Integer ProductID) {
		this.productID = ProductID;
	}
	
	
	@Override
	public String toString() {
		return "UserBasket [userbasketID=" + userbasketID + ", ProductID=" + productID +" ] ";
	}
	
	
	

}
