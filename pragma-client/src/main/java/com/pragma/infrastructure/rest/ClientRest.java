package com.pragma.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pragma.application.service.ClientService;
import com.pragma.domain.TypeDocument;
import com.pragma.infrastructure.rest.dto.ClientDto;
import com.pragma.infrastructure.rest.mapper.IClientMapper;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_CLIENT;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_CLIENT_METHOD_FIND_BY_ID;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_CLIENT_METHOD_FIND_TYPE_AND_DOCUMENT;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_CLIENT_METHOD_FIND_ALL;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_CLIENT_METHOD_FIND_ALL_HIGHER_OR_EQUALS_AGE;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_CLIENT_METHOD_FIND_ALL_TYPE;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_DELETE_BY_ID;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_SAVE;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_UPDATE;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(ENDPOINT_CONTROLLER_CLIENT)
public class ClientRest {

	@Autowired
	ClientService clientService;
	@Autowired
	IClientMapper clientMapper;

	@GetMapping(value = ENDPOINT_CONTROLLER_CLIENT_METHOD_FIND_BY_ID)
	public ResponseEntity<ClientDto<TypeDocument>> findById(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(clientMapper.toDto(clientService.findById(id)));
	}

	@GetMapping(value = ENDPOINT_CONTROLLER_CLIENT_METHOD_FIND_TYPE_AND_DOCUMENT)
	public ResponseEntity<ClientDto<TypeDocument>> findByTypeAndDocument(@PathVariable("type") TypeDocument type,
			@PathVariable("document") Long document) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(clientMapper.toDto(clientService.findByTypeAndDocument(type, document)));
	}

	@GetMapping(value = ENDPOINT_CONTROLLER_CLIENT_METHOD_FIND_ALL)
	public ResponseEntity<List<ClientDto<TypeDocument>>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(clientMapper.toDtoList(clientService.findAll()));
	}

	@GetMapping(value = ENDPOINT_CONTROLLER_CLIENT_METHOD_FIND_ALL_HIGHER_OR_EQUALS_AGE)
	public ResponseEntity<List<ClientDto<TypeDocument>>> findByHigherOrEqualsAgeAll(@PathVariable("age") Integer age) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(clientMapper.toDtoList(clientService.findByHigherOrEqualsAge(age)));
	}

	@GetMapping(value = ENDPOINT_CONTROLLER_CLIENT_METHOD_FIND_ALL_TYPE)
	public ResponseEntity<List<ClientDto<TypeDocument>>> findByTypeAll(@PathVariable("type") TypeDocument type) {
		return ResponseEntity.status(HttpStatus.OK).body(clientMapper.toDtoList(clientService.findByType(type)));
	}

	@PostMapping(value = ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_SAVE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Servicio registrar un cliente", httpMethod = "POST")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<ClientDto<TypeDocument>> save(
			@ApiParam(value = "Informacion Cliente Registrar", required = true) @RequestPart ClientDto<TypeDocument> clientDto,
			@RequestParam("fileMysql") MultipartFile multipartFileMysql,
			@RequestParam("fileMongoDB") MultipartFile multipartFileMongoDb) {
		return ResponseEntity.status(HttpStatus.CREATED).body(clientMapper
				.toDto(clientService.save(clientMapper.toEntity(clientDto), multipartFileMysql, multipartFileMongoDb)));
	}

	@PutMapping(value = ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_UPDATE)
	public ResponseEntity<ClientDto<TypeDocument>> update(@RequestBody ClientDto<TypeDocument> clientDto) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(clientMapper.toDto(clientService.update(clientMapper.toEntity(clientDto))));
	}

	@DeleteMapping(value = ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_DELETE_BY_ID)
	public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.deleteById(id));
	}
}
