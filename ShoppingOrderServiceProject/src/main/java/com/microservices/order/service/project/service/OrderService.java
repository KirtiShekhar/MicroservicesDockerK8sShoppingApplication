package com.microservices.order.service.project.service;

import com.microservices.order.service.project.dto.OrderRequest;
import com.microservices.order.service.project.dto.OrderResponse;
import com.microservices.order.service.project.entity.Order;

public interface OrderService {

	OrderResponse getOrderDetails(Long orderId);

	Order placeOrder(OrderRequest orderRequest);

}
