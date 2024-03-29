package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.Product;

@Repository
public interface IProductRepository	extends JpaRepository<Product, Integer> {
	

}
