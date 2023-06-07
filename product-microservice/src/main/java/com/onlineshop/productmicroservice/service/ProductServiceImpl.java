package com.onlineshop.productmicroservice.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.google.gson.Gson;
import com.onlineshop.productmicroservice.dao.ProductDao;
import com.onlineshop.productmicroservice.model.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductServie{
	
	private final ProductDao productDao;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private Gson gson;
	
	@Override
	@Transactional
	public Product saveProduct(Product product) throws Exception {
		Product saveProduct = productDao.save(product);
		this.sendMessage(saveProduct);
		return saveProduct;
	}

	@Override
	public List<Product> findAllProducts() {
		return productDao.findAll();
	}
	
	@Override
	public List<Product> findProductsByUserId(Long userId) {
		return productDao.findProductsByUserId(userId);
	}
	
	private void sendMessage(Product product) {
		ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send("user-service-event", gson.toJson(product));
	}

}
