package com.naming.ShoppingMall.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="orders")
public class Orders {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ordersId")
	private Integer ordersId;
	
	@Column(name="productid")
	private Integer productid;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="time", nullable = false)
	private Date time;
	
	
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
	
	public Date gettime() {
		return time;
	}
	public void settime(Date time) {
		this.time = time;
	}
	
	
	@Override
	public String toString() {
		return "Orders [ordersId=" + ordersId + ", productid=" + productid + ", quantity=" + quantity
				+ ", time=" + time + "]";
	}
		
	

}
