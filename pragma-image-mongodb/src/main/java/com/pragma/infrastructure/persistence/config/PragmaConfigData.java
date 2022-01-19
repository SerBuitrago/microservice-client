package com.pragma.infrastructure.persistence.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Configuration
@EnableMongoRepositories(
	    basePackages = "com.pragma.infrastructure.persistence.repository")
@ConfigurationProperties("spring.datasource")
@NoArgsConstructor
@Getter
@Setter
@EnableMongoAuditing
@EntityScan(basePackages = "com.pragma.infrastructure.persistence.entity")
public class PragmaConfigData {

}
