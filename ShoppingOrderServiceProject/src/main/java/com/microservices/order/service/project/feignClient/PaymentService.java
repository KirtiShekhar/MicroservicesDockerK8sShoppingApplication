package com.microservices.order.service.project.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservices.order.service.project.dto.PaymentDetails;
import com.microservices.order.service.project.dto.PaymentRequest;
import com.microservices.order.service.project.dto.PaymentResponse;

@FeignClient(name = "microservices-payment-service-project")
public interface PaymentService 
{
	@PostMapping("/api/payment/makeTransaction")
	public PaymentDetails makePayment(@RequestBody PaymentRequest productRequest);
	
	@GetMapping("/api/payment/getTransaction/order")
	public PaymentResponse getPaymentDetailsByOrderId(@RequestParam String orderId);
}
