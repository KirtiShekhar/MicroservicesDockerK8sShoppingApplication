package com.microservices.product.service.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "microservices-product-service-project", version = "2.0", description = "Spring Boot Application Microservices product services project for shopping application"))
public class MicroservicesProductServiceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesProductServiceProjectApplication.class, args);
		System.out.println( "Running Application Spring Boot Microservices Shopping Product Service!" );
	}

}
