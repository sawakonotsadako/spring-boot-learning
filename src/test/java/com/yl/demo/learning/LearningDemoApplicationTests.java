package com.yl.demo.learning;

import com.yl.demo.learning.config.rabbitmq.RabbitMQConfig;
import com.yl.demo.learning.config.rabbitmq.RabbitMQMessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearningDemoApplicationTests {

	@Autowired
	RabbitMQMessageSender rabbitMQMessageSender;

	@Test
	public void contextLoads() throws Exception {

	}
	@Test
	public void testRabbitMQSender() throws Exception {
		rabbitMQMessageSender.send("Hello RabbitMQ! I am sending message to you!");
	}

}
