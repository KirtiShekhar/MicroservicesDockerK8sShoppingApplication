package com.microservices.cloud.gateway.api.project.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Configuration
public class CustomPreFilter implements GlobalFilter
{
	Logger customPreFilterLogger = LoggerFactory.getLogger(CustomPreFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) 
	{
		ServerHttpRequest preRequest = exchange.getRequest();
		
		customPreFilterLogger.info("Requested URL : " + preRequest.getURI().toString());
		
		return chain.filter(exchange);
	}

}
