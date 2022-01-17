package com.pragma.infrastructure.rest.endpoint;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pragma.application.handler.ClientFindByIdHandler;
import com.pragma.domain.model.TypeDocument;
import com.pragma.infrastructure.rest.dto.ClientDto;
import com.pragma.infrastructure.rest.mapper.ClientMapper;

import lombok.RequiredArgsConstructor;

import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_CLIENT;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_CLIENT_METHOD_FIND_BY_ID;;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping(ENDPOINT_CONTROLLER_CLIENT)
@CrossOrigin(origins = "*")
public class ClientFindByIdEndPoint {

	private ClientFindByIdHandler clientFindByIdHandler;
	private ClientMapper clientMapper;

	@GetMapping(value = ENDPOINT_CONTROLLER_CLIENT_METHOD_FIND_BY_ID)
	public ResponseEntity<ClientDto<TypeDocument>> findById(Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(clientMapper.toDto(clientFindByIdHandler.findById(id)));
	}
}
