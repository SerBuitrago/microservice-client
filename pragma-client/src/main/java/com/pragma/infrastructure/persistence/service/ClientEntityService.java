package com.pragma.infrastructure.persistence.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pragma.application.repository.IClientRepository;
import com.pragma.domain.Client;
import com.pragma.domain.TypeDocument;
import com.pragma.infrastructure.exception.PragmaException;
import com.pragma.infrastructure.feign.IImageMongoDbFeign;
import com.pragma.infrastructure.feign.IImageMysqlFeign;
import com.pragma.infrastructure.persistence.entity.ClientEntity;
import com.pragma.infrastructure.persistence.mapper.IClientEntityMapper;
import com.pragma.infrastructure.persistence.repository.IClientEntityRepository;
import com.pragma.infrastructure.rest.mapper.IClientMapper;
import com.pragma.infrastructure.validate.ClientValidate;

import lombok.RequiredArgsConstructor;

import static com.pragma.infrastructure.util.Pragma.isString;
import static com.pragma.infrastructure.util.Pragma.isLong;

@RequiredArgsConstructor
@Service
public class ClientEntityService implements IClientRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientEntityService.class);

	private final IClientEntityRepository clientEntityRepository;
	private final IClientEntityMapper clientEntityMapper;
	private final IClientMapper iClientMapper;

	@Autowired
	IImageMongoDbFeign iImageMongoDbFeign;
	
	@Autowired
	IImageMysqlFeign iImageMysqlFeign;

	public Client findById(Long id) {
		Optional<ClientEntity> optional = clientEntityRepository.findById(id);
		return clientEntityMapper.toDomain(optional
				.orElseThrow(() -> new PragmaException("No se ha encontrado ningun cliente con el id " + id + ".")));
	}

	@Override
	public Client findByTypeAndDocument(TypeDocument type, Long document) {
		Client client = clientEntityMapper
				.toDomain(clientEntityRepository.findByTypeAndDocument(type, document));
		if (client == null)
			throw new PragmaException("No existe ningun client con el tipo de documento " + type.name()
					+ " y documento " + document + ".");
		return client;
	}

	@Override
	public List<Client> findAll() {
		return clientEntityMapper.toDomainList(clientEntityRepository.findAll());
	}

	@Override
	public List<Client> findByType(TypeDocument type) {
		return clientEntityMapper.toDomainList(clientEntityRepository.findByType(type));
	}

	@Override
	public List<Client> findByHigherOrEqualsAge(Integer age) {
		return clientEntityMapper.toDomainList(clientEntityRepository.findByHigherOrEqualsAge(age));
	}

	@Override
	public <A> Client save(Client client, A file) {
		client = iClientMapper.toEntity(ClientValidate.save(iClientMapper.toDto(client)));
		if (!testTypeDocument(client.getType(), client.getDocument()))
			throw new PragmaException("Ya existe un cliente con ese documento y tipo de documento.");
		MultipartFile multiPartFile = (MultipartFile) file;
		client.setIdImageMysql(iImageMysqlFeign.save(multiPartFile).getId());
		client.setIdImageMongoDB(iImageMongoDbFeign.save(multiPartFile).get_id());
		client = clientEntityMapper.toDomain(clientEntityRepository.save(clientEntityMapper.toEntity(client)));
		if(client == null)
			throw new PragmaException("No se ha registrado el cliente.");
		return client;
	}

	@Override
	public <A> Client update(Client client) {
		client = iClientMapper.toEntity(ClientValidate.update(iClientMapper.toDto(client)));
		client = testTypeDocument(client);
		client = clientEntityMapper.toDomain(clientEntityRepository.save(clientEntityMapper.toEntity(client)));
		if(client == null)
			throw new PragmaException("No se ha actualizado el cliente.");
		return client;
	}

	@Override
	public boolean deleteById(Long id) {
		Client client = findById(id);
		iImageMysqlFeign.deleteById(client.getIdImageMysql());
		iImageMongoDbFeign.deleteById(client.getIdImageMongoDB());
		deleteById(id);
		return true;
	}

	private boolean testTypeDocument(TypeDocument type, Long document) {
		Client client = null;
		try {
			client = findByTypeAndDocument(type, document);
		} catch (PragmaException e) {
			LOGGER.error("testTypeDocument(TypeDocument type, Long document)", e);
		}
		return client == null;
	}
	
	private Client testTypeDocument(Client client) {
		Client aux = findById(client.getId());
		if (!aux.getType().name().equalsIgnoreCase(client.getName())
				|| !Objects.equals(aux.getDocument(), client.getDocument()))
			if (!testTypeDocument(client.getType(), client.getDocument()))
				throw new PragmaException("Ya existe un cliente con ese documento y tipo de documento.");
		client.setIdImageMongoDB(!isString(client.getIdImageMongoDB()) ?  aux.getIdImageMongoDB() : client.getIdImageMongoDB());
		client.setIdImageMysql(!isLong(client.getIdImageMysql()) ?  aux.getIdImageMysql() : client.getIdImageMysql());
		return client;
	}
}
