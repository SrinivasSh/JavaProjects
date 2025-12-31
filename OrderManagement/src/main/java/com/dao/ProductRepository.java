package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Product;

import jakarta.transaction.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	public List<Product> findByProductNameContaining(String name);

	public List<Product> findByPriceGreaterThan(Double price);

	public List<Product> findByProductNameEndsWith(String Name);

	@Query("update Product p set p.stock=:stock where p.productId=:productId")
	@Transactional
	@Modifying
	int updateStock(@Param(value = "productId") long productId, @Param(value = "stock") int stock);
}
