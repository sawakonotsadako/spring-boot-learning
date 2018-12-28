package com.yl.demo.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class LearningDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningDemoApplication.class, args);
	}

}
