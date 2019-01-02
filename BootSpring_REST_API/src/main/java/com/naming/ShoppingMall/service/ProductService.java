package com.naming.ShoppingMall.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naming.ShoppingMall.dao.ProductDao;
import com.naming.ShoppingMall.entities.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public Product createProduct(Product product) {
		return productDao.save(product);
	}
	public Optional<Product> getProductById(Integer productId) {
		return productDao.findById(productId);
	}
	public Iterable<Product> getAllProducts() {
		return productDao.findAll();
	}
	public void deleteProduct(Integer productId) {
		productDao.deleteById(productId);
	}
	
	
//	// Optional은 캡슐화를 뜻한다.
//	// 현재 Update가 정상적으로 이루어지고 있다.
//	public Product updateProduct(Integer productId, String newEmail) {
//		Optional<Product> productFromDb = productDao.findById(productId);
//		productFromDb.get().setEmail(newEmail);
//		Product upadedProduct = productDao.save(productFromDb.get());
//		return upadedProduct;
//	}
	
	


}
