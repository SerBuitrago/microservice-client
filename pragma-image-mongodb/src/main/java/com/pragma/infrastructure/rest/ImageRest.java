package com.pragma.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pragma.application.service.ImageService;
import com.pragma.infrastructure.rest.dto.ImageMongoDbDto;
import com.pragma.infrastructure.rest.mapper.IImageMapper;

import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MONGODB;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_FIND_BY_ID;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_FIND_ALL;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_SAVE;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_UPDATE;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_DELETE_BY_ID;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(ENDPOINT_CONTROLLER_IMAGE_MONGODB)
public class ImageRest {

	@Autowired
	ImageService imageService;

	@Autowired
	IImageMapper iImageMapper;

	@GetMapping(value = ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_FIND_BY_ID)
	public ResponseEntity<ImageMongoDbDto> findById(@PathVariable("id") String id) {
		return ResponseEntity.status(HttpStatus.OK).body(iImageMapper.toDto(imageService.findById(id)));
	}

	@GetMapping(value = ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_FIND_ALL)
	public ResponseEntity<List<ImageMongoDbDto>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(iImageMapper.toDtoList(imageService.findAll()));
	}

	@PostMapping(value = ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_SAVE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImageMongoDbDto> save(@RequestPart("file") MultipartFile multipartFile) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(iImageMapper.toDto(imageService.save(multipartFile)));
	}

	@PutMapping(value = ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_UPDATE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImageMongoDbDto> update(@RequestParam("_id") String _id, @RequestPart("file") MultipartFile multipartFile) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(iImageMapper.toDto(imageService.update(_id, multipartFile)));
	}

	@DeleteMapping(value = ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_DELETE_BY_ID)
	public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
		return ResponseEntity.status(HttpStatus.OK).body(imageService.deleteById(id));
	}
}
