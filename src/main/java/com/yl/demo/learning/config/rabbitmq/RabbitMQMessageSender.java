package com.yl.demo.learning.config.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Slf4j
@Component
public class RabbitMQMessageSender {



    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${mq.email.exchange.name}")
    private String exchangeName;

    @Value("${mq.email.route.key}")
    private String routeKey;

    public void send(String message) {
        log.info("rabbit message is sending...");
        this.rabbitTemplate.convertAndSend(exchangeName, routeKey, message);
        log.info("rabbit message completed");
    }
}
