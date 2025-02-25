package com.scaler.notificationservice.rabbitMqConsumer;

import com.scaler.notificationservice.model.NotificationMessageRequest;
import com.scaler.notificationservice.service.EmailService;
import com.scaler.notificationservice.service.NotificationService;
import com.scaler.notificationservice.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RabbitMQConsumer {
    private NotificationService notificationService;
    private EmailService emailService;

    private SMSService smsService;
    @Autowired
    public RabbitMQConsumer(NotificationService notificationService, EmailService emailService, SMSService smsService) {
        this.notificationService = notificationService;
        this.emailService = emailService;
        this.smsService = smsService;
    }

    //@RabbitListener(queues = "your-queue-name")
    public void receiveMessage(NotificationMessageRequest message) {
        if(Objects.nonNull(message)){
            notificationService.sendNotification(message);
        }
        else {
            throw new IllegalArgumentException("Received a null message. The message is required for processing.");
        }


    }


}
