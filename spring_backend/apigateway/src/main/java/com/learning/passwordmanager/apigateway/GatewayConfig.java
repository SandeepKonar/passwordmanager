package com.learning.passwordmanager.apigateway;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/auth/**")
                        .filters(f -> f.circuitBreaker(config -> config.setName("pwdMgrCircuitBreaker")))
                        .uri("lb://authentication-service"))
                .route("user-management-service", r -> r.path("/user/**")
                        .filters(f -> f.circuitBreaker(config -> config.setName("pwdMgrCircuitBreaker")))
                        .uri("lb://user-management-service"))
                .build();
    }

    @Bean
    public CircuitBreakerRegistry customCircuitBreakerRegistry() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(50) // Percentage of failures before opening the circuit
                .slidingWindowSize(10)    // Number of calls to evaluate failure rate
                .waitDurationInOpenState(Duration.ofSeconds(10)) // How long the circuit remains open
                .permittedNumberOfCallsInHalfOpenState(3)
                .build();

        return CircuitBreakerRegistry.of(config);
    }
}
