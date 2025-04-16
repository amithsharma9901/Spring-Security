package com.example.RabbitMQ_Reciever.config;

import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
public class RabbitMQReceiver {
    @RabbitListener(queues = "message_queue")
    public void receiveMessage(String message) {
        System.out.println("Received: " + message);
    }


}


