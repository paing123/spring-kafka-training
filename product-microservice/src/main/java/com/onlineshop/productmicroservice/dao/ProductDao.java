package com.onlineshop.productmicroservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineshop.productmicroservice.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long>{
	
	public List<Product> findProductsByUserId(Long userId);
}
