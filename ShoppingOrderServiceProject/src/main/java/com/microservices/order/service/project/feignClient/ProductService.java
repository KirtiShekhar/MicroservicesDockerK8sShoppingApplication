package com.microservices.order.service.project.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservices.order.service.project.dto.ProductResponse;

@FeignClient(name = "microservices-product-service-project")
public interface ProductService 
{
	@PutMapping("/api/product/reduceQuantity")
	public void reduceQuantity(@RequestParam Long productId,@RequestParam Long quantity);
	
	@GetMapping("/api/product/getById")
	public ProductResponse getProductById(@RequestParam Long productId);
}
