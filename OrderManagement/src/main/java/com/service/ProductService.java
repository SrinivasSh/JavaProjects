package com.service;

import java.util.List;

import com.dto.ProductRequestDto;
import com.dto.ProductResponseDto;

public interface ProductService {
	
	public ProductResponseDto saveProduct(ProductRequestDto productRequestDto);

	public List<ProductResponseDto> saveProducts(List<ProductRequestDto> productRequestDto);

	public ProductResponseDto findProductById(long id);

	public List<ProductResponseDto> findAllProducts();

	public List<ProductResponseDto> findProductsByName(String name);

	public ProductResponseDto updateProductById(long id, double rating);

	public String deleteProduct(long id);

	public List<ProductResponseDto> findByPriceGreateThan(double price);

	public List<ProductResponseDto> findProductsNamesEndsWith(String name);

	public ProductResponseDto updateProductName(long id, String name);


}
