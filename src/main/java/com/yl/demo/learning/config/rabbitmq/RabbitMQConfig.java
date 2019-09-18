package com.yl.demo.learning.config.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitMQConfig {

    @Value("${mq.email.exchange.name}")
    private String exchangeName;

    @Value("${mq.email.queue.name}")
    private String queueName;

    @Value("${mq.email.route.key}")
    private String routeKey;

    @Bean
    DirectExchange emailExchange() {
        return new DirectExchange(exchangeName);
    }

    @Bean
    Queue emailQueue() {
        return new Queue(queueName);
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(emailQueue()).to(emailExchange()).with(routeKey);
    }


}
