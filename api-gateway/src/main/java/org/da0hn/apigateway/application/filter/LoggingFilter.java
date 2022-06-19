package org.da0hn.apigateway.application.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoggingFilter.class);

  @Override public Mono<Void> filter(final ServerWebExchange exchange, final GatewayFilterChain chain) {
    LOGGER.info("Original request path -> {}", exchange.getRequest().getPath());
    return chain.filter(exchange);
  }
}
