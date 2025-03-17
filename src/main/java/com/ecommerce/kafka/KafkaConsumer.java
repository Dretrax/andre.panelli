package com.ecommerce.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "order.paid", groupId = "ecommerce-group")
    public void consumeOrderPaid(String message) {
        System.out.println("Received order.paid: " + message);
            }
}
