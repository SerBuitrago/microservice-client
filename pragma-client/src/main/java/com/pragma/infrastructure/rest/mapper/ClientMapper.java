package com.pragma.infrastructure.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.pragma.domain.Client;
import com.pragma.domain.TypeDocument;
import com.pragma.infrastructure.rest.dto.ClientDto;

@Mapper(componentModel = "spring")
public interface ClientMapper {

	ClientDto<TypeDocument> toDto(Client client);

	List<ClientDto<TypeDocument>> toDtoList(List<Client> clients);

	Client toEntity(ClientDto<TypeDocument> clientDto);

	List<Client> toEntityList(List<ClientDto<TypeDocument>> clientDtos);
}
