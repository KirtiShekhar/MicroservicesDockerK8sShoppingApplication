package com.microservices.order.service.project.exception;

public class PaymentErrorException extends RuntimeException
{	
	private static final long serialVersionUID=1L;
	
	public PaymentErrorException(String message)
	{
		super(message);
	}
}