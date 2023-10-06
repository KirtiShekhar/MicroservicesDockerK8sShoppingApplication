package com.microservices.payment.service.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.payment.service.project.entity.PaymentDetails;

@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Long> 
{
	PaymentDetails findByOrderId(Long orderId);
}
