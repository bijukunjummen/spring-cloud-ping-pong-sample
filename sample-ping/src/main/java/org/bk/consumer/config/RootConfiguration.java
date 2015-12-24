package org.bk.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RootConfiguration {

    @Bean
    public RestOperations nonLoadbalancedRestTemplate() {
        return new RestTemplate();
    }

}
