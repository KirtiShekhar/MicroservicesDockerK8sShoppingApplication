package com.microservices.configuration.server.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroservicesConfigurationServerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesConfigurationServerProjectApplication.class, args);
		System.out.println("Running application Microservices Configuration Server Project !");
	}

}
