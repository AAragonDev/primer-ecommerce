package com.ecommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.models.User;
import com.ecommerce.repository.IUserRepository;


@Service
public class UserServicesImpl implements IUserServices{

	@Autowired
	private IUserRepository usuariorepository;

	@Override
	public Optional<User> findById(Integer id) {
		// TODO Auto-generated method stub
		return usuariorepository.findById(id);
	}
	
}
