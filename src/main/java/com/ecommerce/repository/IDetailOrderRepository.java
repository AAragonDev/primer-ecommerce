package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.DetailOrder;

@Repository
public interface IDetailOrderRepository extends JpaRepository<DetailOrder, Integer>{

}
