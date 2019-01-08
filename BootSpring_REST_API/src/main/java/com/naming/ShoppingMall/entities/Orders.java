package com.naming.ShoppingMall.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

// Orders DB 정의

@Entity 
@Table(name="orders")
public class Orders {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ordersId", updatable = false, insertable= false)
	private Integer ordersId;
	
	@Column(name="productid")
	private Integer productid;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="time")
	private LocalDateTime time;
	
	
	public Integer getordersId() {
		return ordersId;
	}
	public void setordersId(Integer ordersId) {
		this.ordersId = ordersId;
	}
	public Integer getproductid() {
		return productid;
	}
	public void setproductid(Integer productid) {
		this.productid = productid;
	}
	
	public Integer getquantity() {
		return quantity;
	}
	public void setquantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	public LocalDateTime gettime() {
		return time;
	}
	@PrePersist											// 현재 시간 값을 고정으로 저장하기 위한 어노테이션 
	public void settime() {
		this.time = LocalDateTime.now();
	}
	
	
	@Override
	public String toString() {
		return "Orders [ordersId=" + ordersId + ", productid=" + productid + ", quantity=" + quantity
				+ ", time=" + time + "]";
	}

}
