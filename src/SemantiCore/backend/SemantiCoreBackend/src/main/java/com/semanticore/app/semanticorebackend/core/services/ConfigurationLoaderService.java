package com.semanticore.app.semanticorebackend.core.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class ConfigurationLoaderService {

    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${pulsar.service-url}")
    private String pulsarUrl;

    // This method will be called automatically after bean initialization
    @PostConstruct
    public void validateConfiguration() {
        System.out.println("Validating configurations...");

        // Validate Database URL
        if (databaseUrl == null || databaseUrl.isEmpty()) {
            throw new RuntimeException("Database URL is not configured.");
        } else {
            System.out.println("Database URL: " + databaseUrl);
        }

        // Validate Pulsar URL
        if (pulsarUrl == null || pulsarUrl.isEmpty()) {
            throw new RuntimeException("Pulsar URL is not configured.");
        } else {
            System.out.println("Pulsar URL: " + pulsarUrl);
        }

        System.out.println("All configurations are valid.");
    }
}


