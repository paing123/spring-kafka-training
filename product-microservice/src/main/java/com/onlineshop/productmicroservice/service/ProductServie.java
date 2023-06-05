package com.onlineshop.productmicroservice.service;

import java.util.List;

import com.onlineshop.productmicroservice.model.Product;


public interface ProductServie {
	
	Product saveProduct(Product product) throws Exception;

	List<Product> findAllProducts();
	
	List<Product> findProductsByUserId(Long id);
}
