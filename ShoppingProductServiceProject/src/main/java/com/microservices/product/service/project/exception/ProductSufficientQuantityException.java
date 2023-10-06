package com.microservices.product.service.project.exception;

public class ProductSufficientQuantityException extends RuntimeException
{	
	private static final long serialVersionUID=1L;
	
	public ProductSufficientQuantityException(String message)
	{
		super(message);
	}
}