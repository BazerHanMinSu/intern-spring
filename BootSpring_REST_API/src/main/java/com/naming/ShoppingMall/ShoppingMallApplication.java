package com.naming.ShoppingMall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.naming.ShoppingMall.controller.ProductController;

// SpringBoot가 컴파일 될 때 가장 먼저 실행되는 클래스
// 서비스 시작을 위한 컨트롤러라고 생각하면 된다.

@SpringBootApplication

// 이미지 업로드 하기 위해 작성
@ComponentScan({"com.naming.ShoppingMall", "controller"})


public class ShoppingMallApplication {

	public static void main(String[] args) {
		
		// 이미지 업로드 하기 위해 작
		new java.io.File(ProductController.uploadDirectory).mkdir();
		
		SpringApplication.run(ShoppingMallApplication.class, args);		
	}

}

