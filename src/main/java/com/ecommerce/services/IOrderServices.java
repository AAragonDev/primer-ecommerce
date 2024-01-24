package com.ecommerce.services;

import java.util.List;
import java.util.Optional;

import com.ecommerce.models.Order;
import com.ecommerce.models.Usuario;

public interface IOrderServices {

	List<Order> findAll();
	Optional<Order> findById(Integer id);
	Order Save(Order order);
	String generateOrderNumber();
	List<Order> findByUser(Usuario user);
	
}
