package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.Order;
import com.ecommerce.models.Usuario;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer>{

	List<Order> findByUser(Usuario user);
}
