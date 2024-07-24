package com.gestopago.interfazgestopago.api.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class ApiService {
    private final RestTemplate restTemplate;
    
    public <T> T getForObject(String url, Class<T> responseType) {
        return restTemplate.getForObject(url, responseType);
    }
    
    public <T> T postForObject(String url, Object request, Class<T> responseType) {
        return restTemplate.postForObject(url, request, responseType);
    }
}
