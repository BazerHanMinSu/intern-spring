package com.naming.ShoppingMall.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	// getProperty는 디렉토리 위치를 갖고오기 위한 메소드이며, "user.dir"의 경우 현재 개발된 프로젝트를 말하는 "키" 값이다.
	// 따라서 "/uploads" 디렉토리는 "ShoppingMallApplication.java" 클래스에서 확인할 수 있다 싶히 디렉토리를 생성하기 위한 파일명이다.
	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(value="/create")
	public Product createProduct(@RequestBody Product product){
		return productService.createProduct(product);
	}
	
	@PostMapping(value="/image")
	public String upload(Model model, @RequestParam("files") MultipartFile[] files) {
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
		
		model.addAttribute("msg", "Successfully upload : "+fileNames.toString());
		return "saveSuccess";
		
	}
	
	@GetMapping(value="/{productId}")
	//@RequestMapping(value="/ticket/{ticketId}")
	public Optional<Product> getProductById(@PathVariable("productId")Integer productId){
		return productService.getProductById(productId);
	}
	
	@GetMapping(value="/allproducts")
	public Iterable<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@DeleteMapping(value="/delete/{productId}")
	public void deleteProduct(@PathVariable("productId")Integer productId){
		productService.deleteProduct(productId);
	}
	
	
	/** 데이터를 수정하기 위한 코드 */
//	@PutMapping(value="/{productId}/{newEmail:.+}")
//	public Product updateProduct(@PathVariable("productId")Integer productId,@PathVariable("newEmail")String newEmail){
//		return productService.updateProduct(productId,newEmail);
//	}

}
