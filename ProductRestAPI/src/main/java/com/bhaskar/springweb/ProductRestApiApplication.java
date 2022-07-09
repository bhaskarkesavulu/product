package com.bhaskar.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@EnableCaching
@SpringBootApplication
public class ProductRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductRestApiApplication.class, args);
	}
}
