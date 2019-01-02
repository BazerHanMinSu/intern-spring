package com.naming.ShoppingMall.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="product")
public class Product {
		
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	private Integer productId;
	
	@Column(name="product_name",nullable=false)
	private String productName;
	
//	@Column(name="booking_date")
//	private Date bookingDate;
	
	@Column(name="product_price",nullable=false)
	private String productPrice;
	
	@Column(name="product_image")
	private String productImage;
	
	@Column(name="product_detail")
	private String productDetail;
	
	
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	
	
//	public Date getBookingDate() {
//		return bookingDate;
//	}
//	public void setBookingDate(Date bookingDate) {
//		this.bookingDate = bookingDate;
//	}
	
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productImage=" + productImage + ", productDetail=" + productDetail + "]";
	}
		
	

}
