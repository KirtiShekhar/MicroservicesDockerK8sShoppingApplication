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
public class PaymentDetails 
{
	private Long paymentId;
	private PaymentMode paymentMode;
	private String paymentStatus;
	private LocalDateTime paymentDate;

}
