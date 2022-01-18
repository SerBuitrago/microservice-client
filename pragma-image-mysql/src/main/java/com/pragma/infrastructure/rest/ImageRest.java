package com.pragma.infrastructure.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pragma.application.service.ImageService;
import com.pragma.infrastructure.rest.dto.ImageMysqlDto;
import com.pragma.infrastructure.rest.mapper.IImageMapper;

import lombok.RequiredArgsConstructor;

import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MYSQL;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_FIND_BY_ID;;

@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(ENDPOINT_CONTROLLER_IMAGE_MYSQL)
public class ImageRest {

	private ImageService imageService;
	private IImageMapper iImageMapper;

	@GetMapping(value = ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_FIND_BY_ID)
	public ResponseEntity<ImageMysqlDto> findById(Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(iImageMapper.toDto(imageService.findById(id)));
	}
}
