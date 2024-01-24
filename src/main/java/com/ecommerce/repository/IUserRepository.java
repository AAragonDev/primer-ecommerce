package com.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.Usuario;

@Repository
public interface IUserRepository extends JpaRepository<Usuario, Integer>{
	Optional<Usuario> findByEmail(String email);

}
