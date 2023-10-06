package com.microservices.eureka.server.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroservicesEurekaServerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesEurekaServerProjectApplication.class, args);
		System.out.println("Running application Microservices Eureka Server Project !");
	}

}
