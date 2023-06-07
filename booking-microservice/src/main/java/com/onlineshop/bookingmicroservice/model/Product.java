package com.onlineshop.bookingmicroservice.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Product {
	
    private Long productId;
	
	private Long userId;
	
	private String productName;
	
	private String productType;
}
