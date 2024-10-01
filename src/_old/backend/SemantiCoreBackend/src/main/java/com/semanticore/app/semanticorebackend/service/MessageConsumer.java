package com.semanticore.app.semanticorebackend.service;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.client.api.SubscriptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    private final PulsarClient pulsarClient;

    @Autowired
    public MessageConsumer(PulsarClient pulsarClient) {
        this.pulsarClient = pulsarClient;
    }

    public void consumeMessage(String topic) throws Exception {
        Consumer<String> consumer = pulsarClient.newConsumer(Schema.STRING)
                .topic(topic)
                .subscriptionName("my-subscription")
                .subscriptionType(SubscriptionType.Exclusive)
                .subscribe();
        consumer.receiveAsync().thenAccept(msg -> {
            System.out.println("Message received: " + msg.getValue());
            try {
                consumer.acknowledge(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
