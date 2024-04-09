package com.example.paymentsservice.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
@Service
public class PublisNotification {
    private RabbitTemplate rabbitTemplate;

    public PublisNotification(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessageToTopic(String message) {
        rabbitTemplate.convertAndSend("send-notification", message);

    }
}
