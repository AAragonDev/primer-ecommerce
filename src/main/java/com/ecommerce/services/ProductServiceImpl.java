package com.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.models.Product;
import com.ecommerce.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductServices{
	
	@Autowired
	private IProductRepository productRepository;

	@Override
	public Product save(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public Optional<Product> get(Integer id) {
		
		return productRepository.findById(id);
	}

	@Override
	public void update(Product product) {
		productRepository.save(product);
		
	}

	@Override
	public void delete(Integer id) {
		productRepository.deleteById(id);
		
	}

	@Override
	public List<Product> findAll() {
		
		return productRepository.findAll();
	}

}
