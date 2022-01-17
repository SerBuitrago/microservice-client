package com.pragma.application.handler;

import com.pragma.domain.repository.IClientRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientDeleteByIdHandler {
	
	private final IClientRepository clientRepository;
	
	public boolean deleteById(Long id) {
		clientRepository.deleteById(id);
		return true;
	}

}
