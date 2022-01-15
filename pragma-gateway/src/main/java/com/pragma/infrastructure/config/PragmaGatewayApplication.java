package com.pragma.infrastructure.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PragmaGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PragmaGatewayApplication.class, args);
	}

}
