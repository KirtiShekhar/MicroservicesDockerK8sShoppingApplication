package com.microservices.product.service.project.serviceImplementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.product.service.project.dto.ProductRequest;
import com.microservices.product.service.project.dto.ProductResponse;
import com.microservices.product.service.project.entity.Product;
import com.microservices.product.service.project.exception.ProductNotFoundException;
import com.microservices.product.service.project.exception.ProductSufficientQuantityException;
import com.microservices.product.service.project.mapper.ProductMapper;
import com.microservices.product.service.project.repository.ProductRepository;
import com.microservices.product.service.project.service.ProductService;

@Service
public class ProductServiceImplementation implements ProductService
{
	Logger productServiceLogger = LoggerFactory.getLogger(ProductServiceImplementation.class);
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product saveProduct(ProductRequest productRequest)
	{
		productServiceLogger.info("Saving new Product");
		
		Product product = ProductMapper.mapProductRequestToProduct(productRequest);
		Product savedProduct = productRepository.save(product);
		return savedProduct;
	}
	
	@Override
	public ProductResponse getProductById(long productId)
	{
		productServiceLogger.info("Get the product for the productId : {}",productId);
		
		Product product = productRepository.findById(productId).get();
		
		if(product == null)
		{
			throw new ProductNotFoundException("product not found for the given productId");
		}
			
		ProductResponse productResponse = ProductMapper.mapProductToProductResponse(product);
		return productResponse;
	}
	
	@Override
	public void reduceQuantity(Long productId,Long quantity)
	{
		productServiceLogger.info("Reduce quantity {} for the product with the productId : {}",quantity,productId);
		
		Product product = productRepository.findById(productId).get();
		
		if(product == null)
		{
			throw new ProductNotFoundException("product not found for the given productId");
		}
		
		if(product.getQuantity() < quantity)
		{
			throw new ProductSufficientQuantityException("Entered product does not have suffiecient quantity");
		}
		else
		{
			product.setQuantity(product.getQuantity() - quantity);
			productRepository.save(product);
		}
	}
	

}