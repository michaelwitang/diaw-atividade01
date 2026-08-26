package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ClimaService {

    public String buscarClima(String cidade) {
        return "Buscando clima para: " + cidade;
    }
}