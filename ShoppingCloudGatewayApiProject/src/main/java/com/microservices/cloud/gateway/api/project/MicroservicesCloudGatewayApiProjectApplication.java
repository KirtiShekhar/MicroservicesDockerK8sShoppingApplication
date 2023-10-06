package com.microservices.cloud.gateway.api.project;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "microservices-cloud-gateway-api-project", version = "2.0", description = "Spring Boot Application Microservices cloud gateway api project for shopping application"))
public class MicroservicesCloudGatewayApiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesCloudGatewayApiProjectApplication.class, args);
		System.out.println("Running Application Spring Boot Microservices Shopping Cloud Gateway API Service!");
	}

	@Autowired
	RouteDefinitionLocator routeLocator;

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(productRoute -> productRoute.path("/api/product/**")
						.uri("lb://microservices-product-service-project"))
				.route(orderRoute -> orderRoute.path("/api/payment/**")
						.uri("lb://microservices-payment-service-project"))
				.route(paymentRoute -> paymentRoute.path("/api/order/**")
						.uri("lb://microservices-order-service-project"))
				.build();
	}

	@Bean
	public List<GroupedOpenApi> customServiceApis() {
		List<GroupedOpenApi> serviceGroups = new ArrayList<>();
		List<RouteDefinition> routeDefinations = routeLocator.getRouteDefinitions().collectList().block();
		assert routeDefinations != null;
		routeDefinations.stream()
				.filter(serviceRouteDefination -> serviceRouteDefination.getId().matches(".*-service-project"))
				.forEach(allServicesRouteDefination -> {
					String serviceName = allServicesRouteDefination.getId();
					serviceName.replaceAll("microservices-", "");
					serviceName.replaceAll("-service-project","");
					serviceGroups.add(GroupedOpenApi.builder().pathsToMatch("/api/" + serviceName + "/**")
							.group(serviceName).build());
				});
		return serviceGroups;
	}
}
