package com.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	public String generateOrderNumber() {
		int num=0;
		String concatNum="";
		
		List<Order> orders = findAll();
		
		List<Integer> numbers = new ArrayList<Integer>();
		
		orders.stream().forEach(o-> numbers.add(Integer.parseInt(o.getNumber())));
		
		if(orders.isEmpty()) {
			num = 1;
		}else {
			num = numbers.stream().max(Integer::compare).get();	
			num++;
		}
		
		concatNum = String.valueOf(num);
		int digits = concatNum.length();
		
		for (int j=digits;j<=9;j++) {
			concatNum="0"+concatNum;
		}
		return concatNum;
	}
}
