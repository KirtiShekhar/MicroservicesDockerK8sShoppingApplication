package com.microservices.product.service.project.mapper;

import com.microservices.product.service.project.dto.ProductRequest;
import com.microservices.product.service.project.dto.ProductResponse;
import com.microservices.product.service.project.entity.Product;

public class ProductMapper 
{
	public static Product mapProductRequestToProduct(ProductRequest productRequest)
	{
		Product product = new Product();
		product.setProductName(productRequest.getProductName());
		product.setProductDescription(productRequest.getProductDescription());
		product.setPrice(productRequest.getPrice());
		product.setQuantity(productRequest.getQuantity());
		return product;
	}
	
	public static ProductResponse mapProductToProductResponse(Product product)
	{
		ProductResponse productResponse = new ProductResponse();
		productResponse.setProductId(product.getProductId());
		productResponse.setProductName(product.getProductName());
		productResponse.setProductDescription(product.getProductDescription());
		productResponse.setPrice(product.getPrice());
		productResponse.setQuantity(product.getQuantity());
		return productResponse;
	}

}
