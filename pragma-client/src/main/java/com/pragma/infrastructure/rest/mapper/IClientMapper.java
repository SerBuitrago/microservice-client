package com.pragma.infrastructure.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.pragma.domain.Client;
import com.pragma.infrastructure.rest.dto.ClientDto;

@Mapper(componentModel = "spring")
public interface IClientMapper {

	ClientDto toDto(Client client);

	List<ClientDto> toDtoList(List<Client> clients);

	Client toEntity(ClientDto clientDto);

	List<Client> toEntityList(List<ClientDto> clientDtos);
}
