package com.pragma.application.handler;

import com.pragma.domain.model.Client;
import com.pragma.domain.repository.IClientRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientFindByIdHandler {

	private IClientRepository clientRepository;

	public Client findById(Long id) {
		return clientRepository.findById(id);
	}
}
