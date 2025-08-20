package com.example.escoclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient escoWebClient() {
        return WebClient.builder()
                .baseUrl("https://ec.europa.eu/esco/api")
                .build();
    }

}
