package com.microservices.order.service.project.entity;

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
@Table(name = "microservices_shopping_orders")
public class Order 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Long orderId;
	@Column(name = "product_id")
	private Long productId;
	@Column(name = "order_total_amount")
	private Long orderTotalAmount;
	@Column(name = "order_date")
	private LocalDateTime orderDate;
	@Column(name = "order_status")
	private String orderStatus;
	@Column(name = "order_quntity")
	private Long quantity;
}
