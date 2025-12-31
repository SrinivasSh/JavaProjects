package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.dao.ProductRepository;
import com.dto.ProductRequestDto;
import com.dto.ProductResponseDto;
import com.model.Product;
import com.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	private ProductServiceImpl(ProductRepository productRepository) { // Constructor Injection Autowired
		super();
		this.productRepository = productRepository;
	}

	@Override
	public ProductResponseDto saveProduct(ProductRequestDto productRequestDto) {
		Product product = new Product();
		product.setProductName(productRequestDto.getProductName());
		product.setPrice(productRequestDto.getPrice());
		product.setAvailable(true);
		product.setDiscount(productRequestDto.getDiscount());
		product.setStock(productRequestDto.getStock());

		Product savedProduct = productRepository.save(product);

		ProductResponseDto productResponse = new ProductResponseDto();
		BeanUtils.copyProperties(savedProduct, productResponse);

		return productResponse;
	}

	@Override
	public List<ProductResponseDto> saveProducts(List<ProductRequestDto> productRequestDto) {

		List<Product> productList = buildRequestList(productRequestDto);
		List<Product> savedProducts = productRepository.saveAll(productList);
		List<ProductResponseDto> productResponseDto = buildResponseList(savedProducts);
		return productResponseDto;
	}

	@Override
	public ProductResponseDto findProductById(long id) {
		Product productByID = productRepository.findById(id).get();
		ProductResponseDto productResponseDto = new ProductResponseDto();
		BeanUtils.copyProperties(productByID, productResponseDto);

		return productResponseDto;
	}

	@Override
	public List<ProductResponseDto> findAllProducts() {
		List<Product> getAllProducts = productRepository.findAll();
		return buildResponseList(getAllProducts);
	}

	@Override
	public List<ProductResponseDto> findProductsByName(String name) {
		List<Product> productListByName = productRepository.findByProductNameContaining(name);
		return buildResponseList(productListByName);

	}

	@Override
	public ProductResponseDto updateProductById(long id, double rating) {
		Product product = productRepository.findById(id).get();
		product.setRating(rating);
		Product updateRating = productRepository.save(product);
		ProductResponseDto productResponseDto = new ProductResponseDto();
		BeanUtils.copyProperties(updateRating, productResponseDto);

		return productResponseDto;
	}

	@Override
	public String deleteProduct(long id) {
		Product product = productRepository.findById(id).get();
		productRepository.delete(product);

		return product.getProductName() + " is successfully Deleted";
	}

	@Override
	public List<ProductResponseDto> findByPriceGreateThan(double price) {

		List<Product> priceList = productRepository.findByPriceGreaterThan(price);
		return buildResponseList(priceList);

	}

	@Override
	public List<ProductResponseDto> findProductsNamesEndsWith(String name) {
		List<Product> productList = productRepository.findByProductNameEndsWith(name);
		return buildResponseList(productList);

	}
	
	@Override
	public ProductResponseDto updateProductName(long id, String name) {
		Product product=productRepository.findById(id).get();
		product.setProductName(name);
		Product updateProductName = productRepository.save(product);
		ProductResponseDto productResponseDto = new ProductResponseDto();
		BeanUtils.copyProperties(updateProductName, productResponseDto);
		
		return productResponseDto;
	}


	public List<ProductResponseDto> buildResponseList(List<Product> getAllProducts) {
		List<ProductResponseDto> productResponseDto = new ArrayList<>();
		for (Product products : getAllProducts) {
			ProductResponseDto responseDto = new ProductResponseDto();
			BeanUtils.copyProperties(products, responseDto);
			productResponseDto.add(responseDto);
		}

		return productResponseDto;
	}

	public List<Product> buildRequestList(List<ProductRequestDto> productRequestDto) {
		List<Product> products = new ArrayList<Product>();
		for (ProductRequestDto requestDtoList : productRequestDto) {
			Product product = new Product();
			product.setAvailable(true);
			BeanUtils.copyProperties(requestDtoList, product);
			products.add(product);

		}
		return products;
	}

	
}
