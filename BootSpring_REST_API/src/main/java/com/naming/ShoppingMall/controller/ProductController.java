package com.naming.ShoppingMall.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.naming.ShoppingMall.entities.Product;
import com.naming.ShoppingMall.service.ProductService;

@RestController
@RequestMapping(value="/products")

public class ProductController {
	
	
	// 이미지 저장하기 위한 코드
	// getProperty는 디렉토리 위치를 갖고오기 위한 메소드이며, "user.dir"의 경우 현재 프로젝트의 파일 위치 값을 알아낼 수 있는 "키" 값이다.
	// "ShoppingMallApplication.java" 클래스에서 디렉토리를 생성할 수 있도록 작성했기 때문에 "/uploads" 디렉토리 생성이 가능하다. 
	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	
	
	@Autowired
	private ProductService productService;
	
	
	// 각각의 key 값에 따라 value 값을 받아온다.
	// 이미지 파일은 MultipartFile로 받아온다.
	// 이미지 파일을 서버내 특정 디렉토리에 저장한다.
	// 저장되었을 경우 해당 이미지 파일의 경로를 String으로 저장한다.
	@PostMapping
	public Product createProduct(@RequestParam("productName")String name, 
								@RequestParam("productPrice")String price, 
								@RequestParam("productImage") MultipartFile[] files,
								@RequestParam("productDetail")String detail) {
		
		Product product = new Product();
		
		StringBuilder fileNames = new StringBuilder();
		for(MultipartFile file : files) {
			
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename());
			
			try {
				Files.write(fileNameAndPath, file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		product.setProductName(name);
		product.setProductPrice(price);
		product.setProductImage(uploadDirectory +"/"+ fileNames.toString());
		product.setProductDetail(detail);
			
		
		return productService.createProduct(product);
		
	}
	
	
	@GetMapping(value="/{productId}")
	//@RequestMapping(value="/ticket/{ticketId}")
	public Optional<Product> getProductById(@PathVariable("productId")Integer productId){
		return productService.getProductById(productId);
	}
	
	@GetMapping
	public Iterable<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@DeleteMapping(value="/{productId}")
	public void deleteProduct(@PathVariable("productId")Integer productId){
		productService.deleteProduct(productId);
	}
	
	
	/** 데이터를 수정하기 위한 코드 */
//	@PutMapping(value="/{productId}/{newEmail:.+}")
//	public Product updateProduct(@PathVariable("productId")Integer productId,@PathVariable("newEmail")String newEmail){
//		return productService.updateProduct(productId,newEmail);
//	}

}
