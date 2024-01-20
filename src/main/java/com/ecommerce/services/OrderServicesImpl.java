package com.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.models.Order;
import com.ecommerce.repository.IOrderRepository;

@Service
public class OrderServicesImpl implements IOrderServices{
	
	@Autowired
	private IOrderRepository orderRepository;

	@Override
	public Order Save(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

}
