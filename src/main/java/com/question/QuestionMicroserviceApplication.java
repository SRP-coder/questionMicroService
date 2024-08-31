package com.question;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuestionMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionMicroserviceApplication.class, args);
	}

}
