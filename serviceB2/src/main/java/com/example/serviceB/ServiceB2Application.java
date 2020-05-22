package com.example.serviceB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceB2Application {

	public static void main(String[] args) {
		SpringApplication.run(ServiceB2Application.class, args);
	}

}
