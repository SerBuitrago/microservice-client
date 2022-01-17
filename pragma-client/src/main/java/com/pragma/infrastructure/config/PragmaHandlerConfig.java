package com.pragma.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pragma.application.handler.ClientFindByIdHandler;
import com.pragma.domain.repository.IClientRepository;

@Configuration
public class PragmaHandlerConfig {
	
	@Bean
	public ClientFindByIdHandler clientFindByIdHandler(IClientRepository clientRepository) {
		System.out.println("Entro");
		return new ClientFindByIdHandler(clientRepository);
	}

}
