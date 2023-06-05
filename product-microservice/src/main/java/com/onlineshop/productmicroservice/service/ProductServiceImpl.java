package com.onlineshop.productmicroservice.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.onlineshop.productmicroservice.dao.ProductDao;
import com.onlineshop.productmicroservice.model.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductServie{

	private final ProductDao productDao;
	
	@Override
	@Transactional
	public Product saveProduct(Product product) throws Exception {
		return productDao.save(product);
	}

	@Override
	public List<Product> findAllProducts() {
		return productDao.findAll();
	}
	
	@Override
	public List<Product> findProductsByUserId(Long userId) {
		return productDao.findProductsByUserId(userId);
	}

}
