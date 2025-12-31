package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.ProductRequestDto;
import com.dto.ProductResponseDto;
import com.service.ProductService;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/products")
public class ProductController {

//	private final ProductService productService;
//
//	private ProductController(ProductService productService) {    ///Constructor Injection
//		super();
//		this.productService = productService;
//	}
	
	@Autowired
	ProductService productService;     //Field Injection

	@PostMapping("/save")
	@Timed(value="product.save.time")
	@Counted(value="product.save.count")
	public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {

		return productService.saveProduct(productRequestDto);
	}

	@PostMapping("/saveAll")
	@Timed(value="product.saveAll.time")
	@Counted(value="product.saveAll.count")

	public List<ProductResponseDto> createAllProducts(@RequestBody List<ProductRequestDto> productRequestDto) {

		return productService.saveProducts(productRequestDto);
	}

	@GetMapping("/getById/{id}")
	public ProductResponseDto getProductById(@PathVariable("id") long id) {

		return productService.findProductById(id);
	}

	@GetMapping("/getAll")
	public List<ProductResponseDto> getAllProducts() {

		return productService.findAllProducts();
	}

	@GetMapping("/greaterThan/{price}")
	public List<ProductResponseDto> getAllProductsgreaterThan(@PathVariable("price") double price) {

		return productService.findByPriceGreateThan(price);
	}

	@GetMapping("/endsWith/{name}")
	public List<ProductResponseDto> getNamesEndsWith(@PathVariable("name") String name) {

		return productService.findProductsNamesEndsWith(name);
	}

	@GetMapping("/getByName/{name}")
	public List<ProductResponseDto> getAllProductsByName(@PathVariable("name") String name) {

		return productService.findProductsByName(name);
	}

	@PutMapping("/update/{id}")
	public ProductResponseDto updateProduct(@PathVariable("id") long id, @RequestParam("rating") double rating) {

		return productService.updateProductById(id, rating);
	}

	@PutMapping("/updateName/{id}")
	public ProductResponseDto updateProductName(@PathVariable("id") long id, @RequestParam("name") String name) {

		return productService.updateProductName(id, name);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") long id) {

		return productService.deleteProduct(id);
	}

}
