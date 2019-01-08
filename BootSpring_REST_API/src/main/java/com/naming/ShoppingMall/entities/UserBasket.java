package com.naming.ShoppingMall.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name="userbasket")
public class UserBasket {
	
	
	/**
	 * [2019.1.2(수)]
	 * - 변수명과 컬럼명은 통일시킬 것
	 * - 명칭이 통일되지 않으면 데이터 입출력이 안된다.
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userbasketId")
	private Integer userbasketId;
	
	@Column(name="productid", updatable = false, insertable = false)
	private Integer productid;
	
	
	public Integer getuserbasketId() {
		return userbasketId;
	}
	public void setuserbasketId(Integer userbasketId) {
		this.userbasketId = userbasketId;
	}
	
	
	public Integer getproductid() {
		return productid;
	}
	public void setproductid(Integer productid) {
		this.productid = productid;
	}
	
	
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="product_id", insertable = false)
	private Product product;
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct (Product product) {
		this.product = product;
	}
	
	
	
	@Override
	public String toString() {
		return "userbasket [userbasketID=" + userbasketId + ", ProductID=" + productid +" ] ";
	}
	
	
	

}
