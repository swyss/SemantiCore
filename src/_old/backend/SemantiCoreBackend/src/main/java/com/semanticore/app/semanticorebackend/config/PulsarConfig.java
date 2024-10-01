package com.semanticore.app.semanticorebackend.config;

import org.apache.pulsar.client.api.ClientBuilder;
import org.apache.pulsar.client.api.PulsarClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PulsarConfig {

    @Bean
    public PulsarClient pulsarClient() throws Exception {
        ClientBuilder clientBuilder = PulsarClient.builder();
        return clientBuilder.serviceUrl("pulsar://localhost:6650").build();
    }
}
