package com.example.RabittMq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.RabbitMq.config.RabbitMQConfiguration;

@SpringBootApplication
public class RabittMqApplication implements CommandLineRunner{

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(RabittMqApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception{
		System.out.println("Sending message....");
		rabbitTemplate.convertAndSend(RabbitMQConfiguration.TOPIC_EXCHANGE_NAME,"message_routing_key",  "hello from Rabbitmq");
	System.out.println("message sent ");
	}

}
