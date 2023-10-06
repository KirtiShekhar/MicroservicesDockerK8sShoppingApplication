package com.microservices.payment.service.project.service;

import com.microservices.payment.service.project.dto.PaymentRequest;
import com.microservices.payment.service.project.dto.PaymentResponse;
import com.microservices.payment.service.project.entity.PaymentDetails;

public interface PaymentDetailsService {

	PaymentResponse getPaymentDetailsByOrderId(String orderId);

	PaymentDetails makePayment(PaymentRequest productRequest);

}
