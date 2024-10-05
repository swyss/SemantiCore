package com.semanticore.app.semanticorebackend.core.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceHealthChecker {

    private final RestTemplate restTemplate = new RestTemplate();

    public void checkServiceHealth(String serviceUrl) {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(serviceUrl + "/actuator/health", String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                System.out.println("Service at " + serviceUrl + " is healthy");
            } else {
                System.out.println("Service at " + serviceUrl + " is NOT healthy");
            }
        } catch (Exception e) {
            System.out.println("Failed to check health for service at " + serviceUrl);
        }
    }
}

