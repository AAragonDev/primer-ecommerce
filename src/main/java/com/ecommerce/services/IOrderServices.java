package com.ecommerce.services;

import java.util.List;

import com.ecommerce.models.Order;

public interface IOrderServices {

	List<Order> findAll();
	Order Save(Order order);
	String generateOrderNumber();
}
