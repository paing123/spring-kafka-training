package com.onlineshop.bookingmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.onlineshop.bookingmicroservice.model.Product;

@RestController
public class KafkaConsumerController {

	@Autowired
	private Gson gson;

	@KafkaListener(topics = { "user-service-event" })
	public void getTopics(@RequestBody String newProduct) {
		System.out.println("Kafka event consumed is: " + newProduct);
		Product model = gson.fromJson(newProduct, Product.class);
		System.out.println("Model converted value: " + model.toString());
	}
}