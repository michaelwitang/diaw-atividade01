package com.example.demo.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class OpenMeteoClient {

    private final RestClient restClient;

    public OpenMeteoClient() {
        this.restClient = RestClient.builder()
                .baseUrl("https://geocoding-api.open-meteo.com")
                .build();
    }

    public JsonNode buscarCidade(String cidade) {

        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/search")
                        .queryParam("name", cidade)
                        .queryParam("count", 1)
                        .queryParam("language", "pt")
                        .queryParam("format", "json")
                        .build())
                .retrieve()
                .body(JsonNode.class);
    }
}