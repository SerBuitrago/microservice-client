package com.pragma.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pragma.application.service.ImageService;
import com.pragma.infrastructure.rest.dto.ImageMysqlDto;
import com.pragma.infrastructure.rest.mapper.IImageMapper;

import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MYSQL;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_DELETE_BY_ID;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_FIND_ALL;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_SAVE;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_UPDATE;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_FIND_BY_ID;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(ENDPOINT_CONTROLLER_IMAGE_MYSQL)
public class ImageRest {

	@Autowired
	ImageService imageService;

	@Autowired
	IImageMapper iImageMapper;

	@GetMapping(value = ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_FIND_BY_ID)
	public ResponseEntity<ImageMysqlDto> findById(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(iImageMapper.toDto(imageService.findById(id)));
	}

	@GetMapping(value = ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_FIND_ALL)
	public ResponseEntity<List<ImageMysqlDto>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(iImageMapper.toDtoList(imageService.findAll()));
	}

	@PostMapping(value = ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_SAVE)
	public ResponseEntity<ImageMysqlDto> save(@RequestParam("fileMysql") MultipartFile multipartFile) {
		return ResponseEntity.status(HttpStatus.CREATED).body(iImageMapper.toDto(imageService.save(multipartFile)));
	}

	@PutMapping(value = ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_UPDATE)
	public ResponseEntity<ImageMysqlDto> update(@RequestParam("id") Long id,
			@RequestParam("fileMysql") MultipartFile multipartFile) {
		return ResponseEntity.status(HttpStatus.OK).body(iImageMapper.toDto(imageService.update(id, multipartFile)));
	}

	@DeleteMapping(value = ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_DELETE_BY_ID)
	public ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(imageService.deleteById(id));
	}
}
