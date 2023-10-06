package com.microservices.product.service.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.product.service.project.dto.ProductRequest;
import com.microservices.product.service.project.dto.ProductResponse;
import com.microservices.product.service.project.entity.Product;
import com.microservices.product.service.project.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/product")
public class ProductController 
{
	Logger productControllerLogger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("saveProduct")
	@Operation(summary = "Saving new Product in the database")
	public ResponseEntity<?> saveProduct(@RequestBody ProductRequest productRequest)
	{
		productControllerLogger.info("Saving new Product Controller");
		
		Product product = productService.saveProduct(productRequest);
		productControllerLogger.info("Product saved is {} : ", product.toString());
		return new ResponseEntity<>(product,HttpStatus.CREATED);
	}
	
	@GetMapping("getById")
	@Operation(summary = "Get the product for the eneted productId")
	public ResponseEntity<?> getProductById(@RequestParam Long productId)
	{
		productControllerLogger.info("Get the product for the productId : {}",productId);
		
		ProductResponse productResponse = productService.getProductById(productId);
		return new ResponseEntity<>(productResponse,HttpStatus.OK);
	}
	
	@PutMapping("reduceQuantity")
	@Operation(summary = "Reduce quantity for the product with the given productId")
	public ResponseEntity<?> reduceQuantity(@RequestParam Long productId,@RequestParam Long quantity)
	{
		productControllerLogger.info("Reduce quantity {} for the product with the productId : {}",quantity,productId);
		
		productService.reduceQuantity(productId, quantity);
		return new ResponseEntity<>("Quantity reduced successfully",HttpStatus.OK);
	}

}
