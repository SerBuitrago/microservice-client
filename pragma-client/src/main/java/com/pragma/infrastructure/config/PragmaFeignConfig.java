package com.pragma.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

@Configuration
public class PragmaFeignConfig {
	@Bean
	@Primary
	@Scope("prototype")
	public Encoder multipartFormEncoder() {
		return new SpringFormEncoder();
	}

	@Bean
	public feign.Logger.Level multipartLoggerLevel() {
		return feign.Logger.Level.FULL;
	}
}
