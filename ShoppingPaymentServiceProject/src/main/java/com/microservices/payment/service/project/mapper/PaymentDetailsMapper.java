package com.microservices.payment.service.project.mapper;

import java.time.LocalDateTime;

import com.microservices.payment.service.project.dto.PaymentMode;
import com.microservices.payment.service.project.dto.PaymentRequest;
import com.microservices.payment.service.project.dto.PaymentResponse;
import com.microservices.payment.service.project.entity.PaymentDetails;

public class PaymentDetailsMapper 
{
	public static PaymentDetails mapPaymentRequestToPaymentDetails(PaymentRequest productRequest)
	{
		PaymentDetails paymentDetails = new PaymentDetails();
		paymentDetails.setPaymentDate(LocalDateTime.now());
		paymentDetails.setPaymentStatus("SUCCESS");
		paymentDetails.setPaymentMode(productRequest.getPaymentMode().name());
		paymentDetails.setOrderId(productRequest.getOrderId());
		paymentDetails.setPaymentReferenceNumber(paymentDetails.getPaymentReferenceNumber());
		paymentDetails.setOrderTotalAmount(productRequest.getOrderTotalAmount());
		return paymentDetails;
	}
	
	public static PaymentResponse mapPaymentDetailsToPaymentDetailsResponse(PaymentDetails payment)
	{
		PaymentResponse paymentResponse = new PaymentResponse();
		paymentResponse.setPaymentId(payment.getPaymentId());
		paymentResponse.setOrderId(payment.getOrderId());
		paymentResponse.setOrderTotalAmount(payment.getOrderTotalAmount());
		paymentResponse.setPaymentDate(payment.getPaymentDate());
		paymentResponse.setPaymentMode(PaymentMode.valueOf(payment.getPaymentMode()));
		paymentResponse.setPaymentStatus(payment.getPaymentStatus());
		return paymentResponse;
	}

}
