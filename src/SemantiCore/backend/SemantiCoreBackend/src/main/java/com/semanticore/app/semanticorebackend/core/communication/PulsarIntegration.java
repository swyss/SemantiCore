package com.semanticore.app.semanticorebackend.core.communication;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.stereotype.Component;

@Component
public class PulsarIntegration {

    private PulsarClient client;
    private Producer<byte[]> producer;

    public void connect() throws PulsarClientException {
        client = PulsarClient.builder()
                .serviceUrl("pulsar://localhost:6650")
                .build();

        producer = client.newProducer()
                .topic("persistent://public/default/my-topic")
                .create();
    }

    public void sendMessage(String message) throws PulsarClientException {
        producer.send(message.getBytes());
        System.out.println("Message sent to Pulsar: " + message);
    }

    public void disconnect() throws PulsarClientException {
        producer.close();
        client.close();
        System.out.println("Disconnected from Pulsar.");
    }
}
