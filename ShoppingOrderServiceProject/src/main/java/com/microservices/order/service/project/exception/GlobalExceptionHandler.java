package com.microservices.order.service.project.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ErrorResponse> hanldeException(OrderNotFoundException ex)
	{
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setDateTime(LocalDateTime.now());
		errorResponse.setStatuscode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PaymentErrorException.class)
	public ResponseEntity<ErrorResponse> hanldeException(PaymentErrorException ex)
	{
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setDateTime(LocalDateTime.now());
		errorResponse.setStatuscode(HttpStatus.INSUFFICIENT_STORAGE.value());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INSUFFICIENT_STORAGE);
	}
}