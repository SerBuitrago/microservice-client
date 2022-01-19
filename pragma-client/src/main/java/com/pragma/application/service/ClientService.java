package com.pragma.application.service;

import java.util.List;

import com.pragma.application.repository.IClientRepository;
import com.pragma.domain.Client;
import com.pragma.domain.TypeDocument;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientService implements IClientRepository{
	
	private final IClientRepository clientRepository;

	@Override
	public Client findById(Long id) {
		return clientRepository.findById(id);
	}

	@Override
	public Client findByTypeAndDocument(TypeDocument type, Long document) {
		return clientRepository.findByTypeAndDocument(type, document);
	}

	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public List<Client> findByType(TypeDocument type) {
		return clientRepository.findByType(type);
	}

	@Override
	public List<Client> findByHigherOrEqualsAge(Integer age) {
		return clientRepository.findByHigherOrEqualsAge(age);
	}

	@Override
	public <A> Client save(Client client, A file) {
		return clientRepository.save(client, file);
	}

	@Override
	public <A> Client update(Client client) {
		return clientRepository.update(client);
	}

	@Override
	public boolean deleteById(Long id) {
		return clientRepository.deleteById(id);
	}
}
