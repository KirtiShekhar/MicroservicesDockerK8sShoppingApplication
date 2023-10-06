package com.microservices.order.service.project.serviceImplementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.order.service.project.dto.OrderRequest;
import com.microservices.order.service.project.dto.OrderResponse;
import com.microservices.order.service.project.dto.PaymentDetails;
import com.microservices.order.service.project.dto.PaymentRequest;
import com.microservices.order.service.project.dto.PaymentResponse;
import com.microservices.order.service.project.dto.ProductDetails;
import com.microservices.order.service.project.dto.ProductResponse;
import com.microservices.order.service.project.entity.Order;
import com.microservices.order.service.project.exception.OrderNotFoundException;
import com.microservices.order.service.project.exception.PaymentErrorException;
import com.microservices.order.service.project.feignClient.PaymentService;
import com.microservices.order.service.project.feignClient.ProductService;
import com.microservices.order.service.project.mapper.OrderMapper;
import com.microservices.order.service.project.repository.OrderRepository;
import com.microservices.order.service.project.service.OrderService;

@Service
public class OrderServiceImplementation implements OrderService
{
	Logger orderServiceLogger = LoggerFactory.getLogger(OrderServiceImplementation.class);
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Override
	public Order placeOrder(OrderRequest orderRequest)
	{
		orderServiceLogger.info("Placing New Order Request : {}",orderRequest);
		
		productService.reduceQuantity(orderRequest.getProductId(),orderRequest.getQuantity());
		
		orderServiceLogger.info("Creating Order with Status CREATED");
		
		Order order = OrderMapper.mapOrderRequestToOrder(orderRequest);
		
		Order savedOrder = orderRepository.save(order);
		
		orderServiceLogger.info("Calling Payment service to complete the payment");
		
		PaymentRequest paymentRequest = OrderMapper.mapPaymentRequestToOrder(orderRequest, savedOrder);
		
		String orderStatus = null;
		try
		{
			paymentService.makePayment(paymentRequest);
			orderServiceLogger.info("Payment done successfully. Changing the Order Status to PLACED.");		
			orderStatus = "PLACED";
		}
		catch(Exception e)
		{
			orderServiceLogger.info("Error occurred in payment. Changing the Order Status to PAYMENT_FAILED.");
			orderStatus = "PAYMENT_FAILED";
			throw new PaymentErrorException("Error occurred in payment. Changing the Order Status to PAYMENT_FAILED.");
		}
		
		savedOrder.setOrderStatus(orderStatus);
		Order savedOrderWithOrderStatus = orderRepository.save(savedOrder);
		
		orderServiceLogger.info("Order Place successfully with Order Id : {}",savedOrderWithOrderStatus.getOrderId());
		
		return savedOrderWithOrderStatus;
	}
	
	@Override
	public OrderResponse getOrderDetails(Long orderId)
	{
		orderServiceLogger.info("Get the order details for the Order Id : {}",orderId);
		
		Order order = orderRepository.findById(orderId).get();
		
		if(order == null)
		{
			throw new OrderNotFoundException("Order not found for the given Order Id : "+orderId);
		}
		
		orderServiceLogger.info("Invoking Product Service to fetch the product for product Id : {}",order.getProductId());
		
		ProductResponse productResponse = productService.getProductById(order.getProductId());
		
		ProductDetails productDetails = OrderMapper.mapProductResponeToProductDetails(productResponse);
		
		orderServiceLogger.info("Invoking Payment Service to fetch the payment for order Id : {}",order.getOrderId());
		
		PaymentResponse paymentResponse = paymentService.getPaymentDetailsByOrderId(String.valueOf(orderId));
		
		PaymentDetails paymentDetails = OrderMapper.mapPaymentResponeToPaymentDetails(paymentResponse);
		
		OrderResponse orderResponse = OrderMapper.mapOrderToOrderResponse(order, paymentDetails, productDetails);
		
		return orderResponse;
	}
}