package com.microservices.order.service.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest 
{
	private Long orderId;
	private Long orderTotalAmount;
	private String paymentReferenceNumber;
	private PaymentMode paymentMode;
}
