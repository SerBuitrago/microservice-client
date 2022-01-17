package com.pragma.application.handler;

import java.util.List;

import com.pragma.domain.model.Client;
import com.pragma.domain.repository.IClientRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientFindAllHandler {
	
	private final IClientRepository clientRepository;
	
	public List<Client> findAll(){
		return clientRepository.findAll();
	}
}
