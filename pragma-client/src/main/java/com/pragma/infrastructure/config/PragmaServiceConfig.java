package com.pragma.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pragma.application.repository.IClientRepository;
import com.pragma.application.service.ClientService;

@Configuration
public class PragmaServiceConfig {

	@Bean
	public ClientService clientService(IClientRepository clientRepository) {
		return new ClientService(clientRepository);
	}
}
