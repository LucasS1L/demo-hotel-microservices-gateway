package com.example.demohotelmicroservicesgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("docs-hotel", r -> r
                        .path("/api/v1/hoteis/swagger/")
                        .uri("http://localhost:8082/"))
                .route("hoteis", r -> r
                        .path("/api/v1/hoteis/**")
                        .uri("http://localhost:8082/"))
                .route("reservas-cancelamento", r -> r
                        .path("/api/v1/reservas/cancelamento/**")
                        .uri("http://localhost:8084/"))
                .route("reservas", r -> r
                        .path("/api/v1/reservas/**")
                        .uri("http://localhost:8083/"))
                .build();
    }

}
