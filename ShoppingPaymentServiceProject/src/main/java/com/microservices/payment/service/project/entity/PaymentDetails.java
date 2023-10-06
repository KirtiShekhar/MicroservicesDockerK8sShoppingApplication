package com.microservices.payment.service.project.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "microservices_shopping_transaction_details")
public class PaymentDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transaction_id")
	private Long paymentId;
	@Column(name = "order_id")
	private Long orderId;
	@Column(name = "order_total_amount")
	private Long orderTotalAmount;
	@Column(name = "transaction_reference_number")
	private String paymentReferenceNumber;
	@Column(name = "transaction_mode")
	private String paymentMode;
	@Column(name = "transaction_date")
	private LocalDateTime paymentDate;
	@Column(name = "transaction_status")
	private String paymentStatus;
}
