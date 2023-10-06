package com.microservices.product.service.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest 
{
	private String productName;
	private String productDescription;
	private Long price;
	private Long quantity;
}