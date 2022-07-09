package com.bhaskar.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhaskar.springweb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
