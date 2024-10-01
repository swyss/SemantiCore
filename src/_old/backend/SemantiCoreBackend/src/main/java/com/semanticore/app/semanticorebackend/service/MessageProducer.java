package com.semanticore.app.semanticorebackend.service;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private final PulsarClient pulsarClient;

    @Autowired
    public MessageProducer(PulsarClient pulsarClient) {
        this.pulsarClient = pulsarClient;
    }

    public void sendMessage(String topic, String message) throws Exception {
        Producer<String> producer = pulsarClient.newProducer(Schema.STRING)
                .topic(topic)
                .create();
        producer.send(message);
        producer.close();
    }
}
