package com.yl.demo.learning;

import com.yl.demo.learning.config.rabbitmq.RabbitMQConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearningDemoApplicationTests {

	@Autowired
    RabbitMQConfig rabbitMQConfig;

	@Test
	public void contextLoads() throws Exception {

	}
	@Test
	public void testRabbitMQSender() throws Exception {
		rabbitMQConfig.send("Hello RabbitMQ!");
	}

}
