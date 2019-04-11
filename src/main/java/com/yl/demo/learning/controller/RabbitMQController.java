package com.yl.demo.learning.controller;

import com.yl.demo.learning.config.rabbitmq.RabbitMQMessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RabbitMQController {

    @Autowired
    RabbitMQMessageSender rabbitMQMessageSender;

    @RequestMapping(value = "/rabbitmq-sender/{message}")
    public String send(@PathVariable String message) {
        rabbitMQMessageSender.send(message);
        return message + " sent!";
    }
}
