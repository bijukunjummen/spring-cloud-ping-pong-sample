package org.bk.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutes {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(r ->
                        r.path("/samplepong/{segment}")
                                .filters(f -> f.setPath("/{segment}"))
                                .uri("lb://sample-pong"))
                .build();
    }
}