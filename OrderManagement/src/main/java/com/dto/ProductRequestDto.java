package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
	
	private String productName;
	
	private double price;
	
	private double discount;
	
	private int stock;
	
	

}
