package com.ecommerce.services;

import java.util.Optional;

import com.ecommerce.models.Product;

public interface ProductServices {

	public Product save(Product product);
	public Optional<Product> get(Integer id);
	public void update(Product product);
	public void delete(Integer id);
}
