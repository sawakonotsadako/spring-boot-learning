package com.yl.demo.learning.config.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitMQConfig {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${mq.queue.name}")
    private String queueName;

    @Value("${mq.queue.durable}")
    private boolean queueDurable;

    @Value("${mq.queue.exclusive}")
    private boolean queueExclusive;

    @Value("${mq.queue.autoDelete}")
    private boolean queueAutoDelete;

    @Value("${mq.exchange.name}")
    private String exchangeName;

    @Value("${mq.exchange.durable}")
    private boolean exchangeDurable;

    @Value("${mq.exchange.autoDelete}")
    private boolean exchangeAutoDelete;

    @Value("${mq.routekey}")
    private String routeKey;

    public RabbitMQConfig() {
        log.info("RabbitMQ Initialization As Belows:");



    }

    @Bean
    public Queue queue() {
        log.info("queue name="+queueName);
        log.info("queue durable="+queueDurable);
        log.info("queue exclusive="+queueExclusive);
        log.info("queue autoDelete="+queueAutoDelete);
        return new Queue(queueName, queueDurable, queueExclusive, queueAutoDelete);
        //return new Queue(queueName);
    }

    @Bean
    public TopicExchange exchange() {
        log.info("exchange name="+exchangeName);
        log.info("exchange durable="+exchangeDurable);
        log.info("exchange autoDelete="+exchangeAutoDelete);
        return new TopicExchange(exchangeName, exchangeDurable, exchangeAutoDelete);
        //return new TopicExchange(exchangeName);
    }

    @Bean
    public Binding binding() {
        log.info("route key="+routeKey);
        return BindingBuilder.bind(queue()).to(exchange()).with(routeKey);
    }

    public void send(String message) {
        log.info("rabbit message is sending...");
        log.info("exchange name="+exchangeName);
        log.info("route key="+routeKey);
        this.rabbitTemplate.convertAndSend(exchangeName, routeKey, message);
        log.info("rabbit message sent!");
    }
}
