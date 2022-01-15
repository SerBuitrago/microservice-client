package com.pragma.infrastructure.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PragmaEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PragmaEurekaApplication.class, args);
	}

}
