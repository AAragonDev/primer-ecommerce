package com.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByEmail(String email);

}
