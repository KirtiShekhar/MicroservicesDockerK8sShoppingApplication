package com.microservices.order.service.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.order.service.project.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> 
{

}
