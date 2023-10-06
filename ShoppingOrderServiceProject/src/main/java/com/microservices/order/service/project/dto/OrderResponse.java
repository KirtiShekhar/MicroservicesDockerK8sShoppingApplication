package com.microservices.order.service.project.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse 
{
	private Long orderId;
	private Long orderTotalAmount;
	private LocalDateTime orderDate;
	private String orderStatus;
	private ProductDetails productDetails;
	private PaymentDetails paymentDetails;
}