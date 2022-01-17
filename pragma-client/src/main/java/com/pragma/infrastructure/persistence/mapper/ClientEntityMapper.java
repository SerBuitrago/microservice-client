package com.pragma.infrastructure.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.pragma.domain.model.Client;
import com.pragma.infrastructure.persistence.entity.ClientEntity;

@Mapper(componentModel = "spring")
public interface ClientEntityMapper {

	Client toDomain(ClientEntity clientEntity);

	List<Client> toDomainList(List<ClientEntity> clientEntities);

	ClientEntity toEntity(Client client);

	List<ClientEntity> toEntityList(List<ClientEntity> clientEntities);
}
