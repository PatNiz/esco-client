package com.example.escoclient.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EscoService {

    private final WebClient webClient;

    public EscoService(WebClient escoWebClient) {
        this.webClient = escoWebClient;
    }

    public Mono<String> getOccupations(int offset, int limit, String lang) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search")
                        .queryParam("type", "occupation")
                        .queryParam("language", lang)
                        .queryParam("limit", limit)
                        .queryParam("offset", offset)
                        .build())
                .header("Accept", "application/json")
                .retrieve()
                .bodyToMono(String.class);
    }


}
