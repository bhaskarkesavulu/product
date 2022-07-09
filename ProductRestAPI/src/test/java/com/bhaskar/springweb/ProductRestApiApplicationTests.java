package com.bhaskar.springweb;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.bhaskar.springweb.entities.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductRestApiApplicationTests {
	
	
	@Value("${productrestapi.services.url}")
	private String baseURL;
	@Test
	public void testGetProduct() {
		System.out.println(baseURL);
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseURL+"2", Product.class);
		assertNotNull(product);
		assertEquals("Ladies Finger", product.getName());
	}
	
	@Test
	public void testcreateProduct()
	{
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setName("Brinjal");
		product.setDescription("It's Tasty");
		product.setPrice(1000);
		Product newProduct = restTemplate.postForObject(baseURL, product, Product.class);
		assertNotNull(newProduct);
		assertNotNull(newProduct.getId());
		assertEquals("Brinjal", newProduct.getName());
	}
	
	@Test
	public void testupdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseURL+"2", Product.class);
		product.setPrice(200);
		restTemplate.put(baseURL, product);
	}

}
