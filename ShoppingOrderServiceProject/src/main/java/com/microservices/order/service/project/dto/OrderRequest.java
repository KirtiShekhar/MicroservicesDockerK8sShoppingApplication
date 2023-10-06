package com.microservices.order.service.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest 
{
	private Long productId;
	private Long orderTotalAmount;
	private Long quantity;
	private PaymentMode paymentMode;
}