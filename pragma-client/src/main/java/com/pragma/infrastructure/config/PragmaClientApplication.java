package com.pragma.infrastructure.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients(basePackages = "com.pragma.infrastructure.feign")
@SpringBootApplication(scanBasePackages = "com.pragma.infrastructure")
@EntityScan(basePackages = "com.pragma.domain")
public class PragmaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PragmaClientApplication.class, args);
	}
}
