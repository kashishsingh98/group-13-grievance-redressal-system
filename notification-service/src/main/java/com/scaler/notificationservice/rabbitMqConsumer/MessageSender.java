package com.scaler.notificationservice.rabbitMqConsumer;

import com.scaler.notificationservice.configuration.RabbitMqConfig;
import com.scaler.notificationservice.model.NotificationMessageRequest;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    public MessageSender(RabbitTemplate template) {
        this.template = template;
    }

    public void sendMessage(NotificationMessageRequest message) {
        template.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTING_KEY, message);
        System.out.println("Success");
    }
}
