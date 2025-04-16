package com.example.Kafka_Producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Kafka_Producer.model.User;

@RestController
@RequestMapping("kafka")
public class UserController {
    private static final String TOPIC = "Kafka_Example";
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {

        KafkaTemplate kafkaTemplate2 = new KafkaTemplate(null);
		kafkaTemplate2.send(TOPIC, new User(name, "Technology", 12000L));

        return "Published successfully";
    }
}