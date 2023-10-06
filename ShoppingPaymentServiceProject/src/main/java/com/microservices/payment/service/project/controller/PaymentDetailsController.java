package com.microservices.payment.service.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.payment.service.project.dto.PaymentRequest;
import com.microservices.payment.service.project.dto.PaymentResponse;
import com.microservices.payment.service.project.entity.PaymentDetails;
import com.microservices.payment.service.project.service.PaymentDetailsService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/payment")
public class PaymentDetailsController 
{
	Logger paymentDetailsControllerLogger = LoggerFactory.getLogger(PaymentDetailsController.class);
	
	@Autowired
	private PaymentDetailsService paymentDetailsService;
	
	@PostMapping("makeTransaction")
	@Operation(summary = "Making Payment for the order in the database")
	public ResponseEntity<?> makePayment(@RequestBody PaymentRequest productRequest)
	{
		PaymentDetails paymentDetails = paymentDetailsService.makePayment(productRequest);
		paymentDetailsControllerLogger.info("Payment Transaction completed with id : {}",paymentDetails.getPaymentId());
		return new ResponseEntity<>(paymentDetails,HttpStatus.CREATED);
	}
	
	@GetMapping("getTransaction/order")
	@Operation(summary = "Getting payment details for the given order Id")
	public ResponseEntity<?> getPaymentDetailsByOrderId(@RequestParam String orderId)
	{
		paymentDetailsControllerLogger.info("Getting payment details for the order Id : {}",orderId);
		
		PaymentResponse paymentResponse = paymentDetailsService.getPaymentDetailsByOrderId(orderId);
		return new ResponseEntity<>(paymentResponse,HttpStatus.OK);
	}
}
