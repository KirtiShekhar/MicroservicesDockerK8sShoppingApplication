package com.microservices.product.service.project.service;

import com.microservices.product.service.project.dto.ProductRequest;
import com.microservices.product.service.project.dto.ProductResponse;
import com.microservices.product.service.project.entity.Product;

public interface ProductService {

	void reduceQuantity(Long productId, Long quantity);

	ProductResponse getProductById(long productId);

	Product saveProduct(ProductRequest productRequest);

}
