package com.ecommerce.services;

import java.util.List;
import java.util.Optional;

import com.ecommerce.models.User;

public interface IUserServices {
	
	Optional<User> findById(Integer id);
	User save(User user);
	Optional<User> findByEmail(String email);
	List<User> findAll();
}
