package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class ClimaService {
    
    @Value("${weather.api.key}")
    private String apiKey;
    public static final String BASE_URL = "http://api.weatherapi.com/v1/current.json";

    private String consultarURL(String apiUrl) {
        String dados = "";
        RestTemplate restTemplate = new RestTemplate();
        
        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                dados = responseEntity.getBody();
            } else {
                dados = "Falha ao obter dados. Código de status " + responseEntity.getStatusCode();
            }
        } catch (Exception e) {
            dados = "Erro ao comunicar com a API externa: " + e.getMessage();
        }
        
        return dados;
    }
    public String buscarClima(String cidade) {
        String urlCompleta = BASE_URL + "?key=" + apiKey + "&q=" + cidade + "&lang=pt";
        
        return consultarURL(urlCompleta);
    }
}