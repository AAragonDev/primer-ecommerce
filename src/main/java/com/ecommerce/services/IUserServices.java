package com.ecommerce.services;

import java.util.List;
import java.util.Optional;

import com.ecommerce.models.Usuario;

public interface IUserServices {
	
	Optional<Usuario> findById(Integer id);
	Usuario save(Usuario user);
	Optional<Usuario> findByEmail(String email);
	List<Usuario> findAll();
}
