package com.microservices.payment.service.project.serviceImplementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.payment.service.project.dto.PaymentRequest;
import com.microservices.payment.service.project.dto.PaymentResponse;
import com.microservices.payment.service.project.entity.PaymentDetails;
import com.microservices.payment.service.project.mapper.PaymentDetailsMapper;
import com.microservices.payment.service.project.repository.PaymentDetailsRepository;
import com.microservices.payment.service.project.service.PaymentDetailsService;

@Service
public class PaymentDetailsServiceImplementation implements PaymentDetailsService
{
	Logger paymentDetailsServiceLogger = LoggerFactory.getLogger(PaymentDetailsServiceImplementation.class);
	
	@Autowired
	private PaymentDetailsRepository paymentDetailsRepository;
	
	@Override
	public PaymentDetails makePayment(PaymentRequest productRequest)
	{
		paymentDetailsServiceLogger.info("Making Payment for the order --- service");
		
		PaymentDetails paymentDetails = PaymentDetailsMapper.mapPaymentRequestToPaymentDetails(productRequest);
		
		PaymentDetails savedpayment = paymentDetailsRepository.save(paymentDetails);
		
		paymentDetailsServiceLogger.info("Payment Transaction completed with id : {}",paymentDetails.getPaymentId());
		
		return savedpayment;
	}
	
	@Override
	public PaymentResponse getPaymentDetailsByOrderId(String orderId)
	{
		paymentDetailsServiceLogger.info("Getting payment details for the order Id : {}",orderId);
		
		PaymentDetails paymentDetails = paymentDetailsRepository.findByOrderId(Long.valueOf(orderId));
		
		PaymentResponse paymentResponse = PaymentDetailsMapper.mapPaymentDetailsToPaymentDetailsResponse(paymentDetails);
		
		return paymentResponse;
	}
}