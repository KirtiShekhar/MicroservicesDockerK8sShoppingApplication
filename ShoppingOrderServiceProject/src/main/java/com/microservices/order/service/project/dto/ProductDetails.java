package com.microservices.order.service.project.dto;

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
public class ProductDetails 
{
	private Long productId;
	private String productName;
	private String productDescription;
	private Long price;
	private Long quantity;
}