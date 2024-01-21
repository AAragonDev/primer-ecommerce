package com.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.models.DetailOrder;
import com.ecommerce.repository.IDetailOrderRepository;

@Service
public class DetailOrderServicesImpl implements IDetailOrderServices{
	
	@Autowired
	private IDetailOrderRepository detailOrderRepository;

	@Override
	public DetailOrder save(DetailOrder detailOrder) {
		// TODO Auto-generated method stub
		return detailOrderRepository.save(detailOrder);
	}

}
