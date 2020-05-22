package com.example.serviceA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
	 * rest以别名方式调用b服务需要依赖ribbon负载均衡器，在启动类注入restTemplate的时候加上@LoadBalanced注解，
	 * 使其拥有负载均衡能力
	 * @return  RestTemplate.
	 */
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
