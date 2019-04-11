package com.yl.demo.learning.config.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMQMessageConsumer {

    @RabbitListener(queues = "${mq.queue.name}")
    @RabbitHandler
    public void process(String message) {
        log.info("message from RabbitMQ:"+message);

    }
}
