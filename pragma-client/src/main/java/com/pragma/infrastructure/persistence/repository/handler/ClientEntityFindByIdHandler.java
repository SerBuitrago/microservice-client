package com.pragma.infrastructure.persistence.repository.handler;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pragma.domain.model.Client;
import com.pragma.infrastructure.exception.PragmaException;
import com.pragma.infrastructure.persistence.entity.ClientEntity;
import com.pragma.infrastructure.persistence.mapper.ClientEntityMapper;
import com.pragma.infrastructure.persistence.repository.ClientEntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClientEntityFindByIdHandler {

	private final ClientEntityRepository clientEntityRepository;
	private final ClientEntityMapper clientEntityMapper;

	public Client findById(Long id) {
		Optional<ClientEntity> optional = clientEntityRepository.findById(id);
		return clientEntityMapper.toDomain(optional
				.orElseThrow(() -> new PragmaException("No se ha encontrado ningun cliente con el id " + id + ".")));
	}
}
