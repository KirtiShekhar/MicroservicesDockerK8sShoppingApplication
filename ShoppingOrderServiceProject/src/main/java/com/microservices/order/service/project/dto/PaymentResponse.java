package com.microservices.order.service.project.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse 
{
	private Long paymentId;
	private Long orderId;
	private Long orderTotalAmount;
	private PaymentMode paymentMode;
	private LocalDateTime paymentDate;
	private String paymentStatus;

}
