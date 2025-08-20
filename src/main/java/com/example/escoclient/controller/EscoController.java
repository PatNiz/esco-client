package com.example.escoclient.controller;

import com.example.escoclient.service.EscoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EscoController {

    private final EscoService escoService;

    public EscoController(EscoService escoService) {
        this.escoService = escoService;
    }


    @GetMapping("/occupations")
    public Mono<String> getOccupations(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "50") int limit,
            @RequestParam(defaultValue = "en") String lang
    ) {
        return escoService.getOccupations(offset, limit, lang);
    }

}
