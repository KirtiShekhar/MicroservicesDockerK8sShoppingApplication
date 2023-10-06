package com.microservices.order.service.project.mapper;

import java.time.LocalDateTime;

import com.microservices.order.service.project.dto.OrderRequest;
import com.microservices.order.service.project.dto.OrderResponse;
import com.microservices.order.service.project.dto.PaymentDetails;
import com.microservices.order.service.project.dto.PaymentRequest;
import com.microservices.order.service.project.dto.PaymentResponse;
import com.microservices.order.service.project.dto.ProductDetails;
import com.microservices.order.service.project.dto.ProductResponse;
import com.microservices.order.service.project.entity.Order;

public class OrderMapper 
{
	public static Order mapOrderRequestToOrder(OrderRequest orderRequest)
	{
		Order order = new Order();
		order.setOrderTotalAmount(orderRequest.getOrderTotalAmount());
		order.setOrderStatus("CREATED");
		order.setProductId(orderRequest.getProductId());
		order.setOrderDate(LocalDateTime.now());
		order.setQuantity(orderRequest.getQuantity());
		return order;
	}
	
	public static PaymentRequest mapPaymentRequestToOrder(OrderRequest orderRequest,Order order)
	{
		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setOrderId(order.getOrderId());
		paymentRequest.setPaymentMode(orderRequest.getPaymentMode());
		paymentRequest.setOrderTotalAmount(orderRequest.getOrderTotalAmount());
		return paymentRequest;
	}
	
	
	public static OrderResponse mapOrderToOrderResponse(Order order,PaymentDetails paymentDetails,ProductDetails productDetails)
	{
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderId(order.getOrderId());
		orderResponse.setOrderStatus(order.getOrderStatus());
		orderResponse.setOrderTotalAmount(order.getOrderTotalAmount());
		orderResponse.setOrderDate(order.getOrderDate());
		orderResponse.setProductDetails(productDetails);
		orderResponse.setPaymentDetails(paymentDetails);
		return orderResponse;
	}
	
	public static PaymentDetails mapPaymentResponeToPaymentDetails(PaymentResponse paymentResponse)
	{
		PaymentDetails paymentDetails = new PaymentDetails();
		paymentDetails.setPaymentId(paymentResponse.getPaymentId());
		paymentDetails.setPaymentStatus(paymentResponse.getPaymentStatus());
		paymentDetails.setPaymentDate(paymentResponse.getPaymentDate());
		paymentDetails.setPaymentMode(paymentResponse.getPaymentMode());
		return paymentDetails;
	}
	
	public static ProductDetails mapProductResponeToProductDetails(ProductResponse productResponse)
	{
		ProductDetails productDetails = new ProductDetails();
		productDetails.setProductId(productResponse.getProductId());
		productDetails.setProductName(productResponse.getProductName());
		productDetails.setProductDescription(productResponse.getProductDescription());
		productDetails.setPrice(productResponse.getPrice());
		productDetails.setQuantity(productResponse.getQuantity());
		return productDetails;
	}
}
