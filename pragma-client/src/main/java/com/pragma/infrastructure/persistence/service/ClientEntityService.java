package com.pragma.infrastructure.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pragma.application.repository.IClientRepository;
import com.pragma.domain.Client;
import com.pragma.domain.TypeDocument;
import com.pragma.infrastructure.exception.PragmaException;
import com.pragma.infrastructure.persistence.entity.ClientEntity;
import com.pragma.infrastructure.persistence.mapper.ClientEntityMapper;
import com.pragma.infrastructure.persistence.repository.ClientEntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClientEntityService implements IClientRepository{

	private final ClientEntityRepository clientEntityRepository;
	private final ClientEntityMapper clientEntityMapper;

	public Client findById(Long id) {
		Optional<ClientEntity> optional = clientEntityRepository.findById(id);
		return clientEntityMapper.toDomain(optional
				.orElseThrow(() -> new PragmaException("No se ha encontrado ningun cliente con el id " + id + ".")));
	}

	@Override
	public Client findByTypeAndDocument(TypeDocument type, Long document) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> findByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> findByHigherOrEqualsAge(Integer age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <A> Client save(Client client, A file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <A> Client update(Client client, A file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
}
