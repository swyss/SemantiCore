package com.semanticore.app.semanticorebackend.core.utilities;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.springframework.stereotype.Service;

@Service
public class PulsarService {

    private PulsarClient client;
    private Producer<String> producer;

    public void connect() throws PulsarClientException {
        client = PulsarClient.builder()
                .serviceUrl("pulsar://localhost:6650")
                .build();

        producer = client.newProducer(Schema.STRING)
                .topic("persistent://public/default/my-topic")
                .create();
    }

    public void sendMessage(String message) throws PulsarClientException {
        producer.send(message);
    }

    public void disconnect() throws PulsarClientException {
        producer.close();
        client.close();
    }
}
