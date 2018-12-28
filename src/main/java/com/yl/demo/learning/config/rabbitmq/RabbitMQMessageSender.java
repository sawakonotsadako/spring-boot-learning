package com.yl.demo.learning.config.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class RabbitMQMessageSender {


    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${mq.exchange.name}")
    private String exchangeName;

    @Value("${mq.routekey}")
    private String routeKey;

    public void send(String message) {
        log.info("rabbit message is sending...");
        this.rabbitTemplate.convertAndSend(exchangeName, routeKey, message);
        log.info("rabbit message completed");
    }
}
