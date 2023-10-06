package com.microservices.order.service.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableFeignClients("com.microservices.order.service.project.feignClient")
@OpenAPIDefinition(info = @Info(title = "microservices-order-service-project", version = "2.0", description = "Spring Boot Application Microservices order services project for shopping application"))
public class MicroservicesOrderServiceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesOrderServiceProjectApplication.class, args);
		System.out.println( "Running Application Spring Boot Microservices Shopping Order Service!" );
	}

}
