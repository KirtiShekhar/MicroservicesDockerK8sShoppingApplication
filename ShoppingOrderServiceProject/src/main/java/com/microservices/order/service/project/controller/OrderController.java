package com.microservices.order.service.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.order.service.project.dto.OrderRequest;
import com.microservices.order.service.project.dto.OrderResponse;
import com.microservices.order.service.project.entity.Order;
import com.microservices.order.service.project.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/order")
public class OrderController 
{
	Logger orderControllerLogger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("placeOrder")
	@Operation(summary = "Placing a new order for selected product")
	public ResponseEntity<?> placeProduct(@RequestBody OrderRequest productRequest)
	{
		orderControllerLogger.info("Placing a new order for selected product");
		
		Order savedOrder = orderService.placeOrder(productRequest);
		
		orderControllerLogger.info("A new order placed is {} : ", savedOrder.toString());
		
		return new ResponseEntity<>(savedOrder,HttpStatus.CREATED);
	}
	
	@GetMapping("getOrderDetails")
	@Operation(summary = "Get the order details for the given orderId")
	public ResponseEntity<?> getOrderDetails(@RequestParam Long orderId)
	{
		orderControllerLogger.info("Get the order details for the orderId : {}",orderId);
		
		OrderResponse orderResponse = orderService.getOrderDetails(orderId);
		
		return new ResponseEntity<>(orderResponse,HttpStatus.OK);
	}
}
