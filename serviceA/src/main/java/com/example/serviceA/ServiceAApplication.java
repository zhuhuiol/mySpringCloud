package com.example.serviceA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ServiceAApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAApplication.class, args);
	}

	/**
	 * 将RestTemplate注入spring进行管理.
	 * @return  RestTemplate.
	 */
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
