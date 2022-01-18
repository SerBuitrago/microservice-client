package com.pragma.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pragma.application.repository.IImageRepository;
import com.pragma.application.service.ImageService;

@Configuration
public class PragmaServiceConfig {

	@Bean
	public ImageService clientService(IImageRepository iImageRepository) {
		return new ImageService(iImageRepository);
	}
}
