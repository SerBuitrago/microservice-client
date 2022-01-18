package com.pragma.infrastructure.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.pragma.infrastructure")
@EntityScan(basePackages = "com.pragma.domain")
public class PragmaImageMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(PragmaImageMongodbApplication.class, args);
	}

}
