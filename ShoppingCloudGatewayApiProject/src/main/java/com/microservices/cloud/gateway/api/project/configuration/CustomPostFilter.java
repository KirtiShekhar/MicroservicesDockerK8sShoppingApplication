package com.microservices.cloud.gateway.api.project.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Configuration
public class CustomPostFilter implements GlobalFilter
{
	Logger customPostFilterLogger = LoggerFactory.getLogger(CustomPostFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) 
	{
		ServerHttpResponse postResponse = exchange.getResponse();
		
		customPostFilterLogger.info("Requested URL : " + postResponse.getStatusCode());
		
		return chain.filter(exchange);
	}

}